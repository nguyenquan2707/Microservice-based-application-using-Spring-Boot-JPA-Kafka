package com.example.customer.service;


import com.example.customer.model.dao.ICustomerDao;
import com.example.customer.model.entity.Customer;
import com.example.customer.model.entity.CustomerSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    ICustomerDao customerDao;

    //getCustomer
    public Customer getCustomer(String mobileNo){
        Customer customer = customerDao.getCustomer(mobileNo);
        return customer;
    }


    //registerCustomer
    public Customer registerCustomer(Customer customer){
        CustomerSale customerSale = customer.getSale();
        customer.setSale(customerSale);

        return customerDao.addCustomer(customer);
    }

    //unregisterCustomer
    public Customer unRegisterCustomer(Customer customer){

        return customerDao.deleteCustomer(customer);
    }
}
