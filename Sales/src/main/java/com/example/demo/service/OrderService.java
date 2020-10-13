package com.example.demo.service;

import com.example.demo.exception.OrderNotFoundExcedption;
import com.example.demo.model.entity.Customer;
import com.example.demo.model.entity.CustomerSale;
import com.example.demo.model.entity.Order;
import com.example.demo.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerSaleService saleService;

    @Transactional
    public Order registerOrder(Order order){

        //check new customer
        Customer customer = order.getCustomer();

        //if new, register first
        if(customer.getId() == 0){
            customer = customerService.registerCustomer(customer);
        }

        //save order
        Order ord = orderRepository.saveOrder(order);

        //update sale info for this particular customer
        CustomerSale customerSale = customer.getSale();

        int currentSale = customerSale.getTotal_sale();

        customerSale.setTotal_sale(currentSale ++);

        saleService.updateTotalSale(customerSale);

        //send messages by Kafka including customer and customer sale info

        return ord;
    }

    @Transactional
    public Order removeOrderById(long orderId){

        //check id
        if(orderRepository.getOrderByID(orderId) == null){
            throw new OrderNotFoundExcedption("No such order found !");
        }

        //remove
        Order order = orderRepository.deleteOrder(orderId);

        //update sale info for the customer
        Customer customer = order.getCustomer();

        CustomerSale customerSale = customer.getSale();

        saleService.updateTotalSale(customerSale);

        //send messages by Kafka including customer sale info

        return order;
    }

    @Transactional
    public int removeAllOrdersForCustomer(String customerMobileNo){

        //get customer
        Customer customer = customerService.getCustomer(customerMobileNo);

        //get order list
        List<Order> orderList = orderRepository.getOrderList(customer.getId());

        //remove orders
        for(Order order : orderList){
            orderRepository.deleteOrder(order.getId());
        }

        //update sale info
        CustomerSale customerSale = customer.getSale();

        customerSale.setTotal_sale(0);

        saleService.updateTotalSale(customerSale);

        //send messages by Kafka including customer and customer sale info

        return orderList.size();
    }

    public List<Order> getAllOrder(String mobileNo){

        Customer customer = customerService.getCustomer(mobileNo);

        return orderRepository.getOrderList(customer.getId());
    }
}
