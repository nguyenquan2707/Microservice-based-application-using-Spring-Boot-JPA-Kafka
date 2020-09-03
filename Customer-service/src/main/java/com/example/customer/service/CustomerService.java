package com.example.customer.service;


import com.example.customer.exceptions.NoCustomerExistException;
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

        if(customer == null)
            throw new NoCustomerExistException("No such customer exist with mobile no "+mobileNo);

        return customer;
    }


    //registerCustomer
    public Customer registerCustomer(Customer customer){

        // check already present
        Customer cust = customerDao.getCustomer(customer.getMobile_no());

        //if present, update
        if(cust != null)
            return customerDao.updateCustomer(cust);

        // if not present , save new
        CustomerSale sale = new CustomerSale();
        customer.setSale(sale);

        return customerDao.addCustomer(customer);
    }

    //unregisterCustomer
    public Customer unRegisterCustomer(String mobileNo){

        Customer customer = customerDao.deleteCustomer(mobileNo);

        if(customer == null)
            throw new NoCustomerExistException("No such customer exist with mobile no "+mobileNo);

        return customer;
    }
}

