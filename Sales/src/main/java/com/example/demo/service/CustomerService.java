package com.example.demo.service;

import com.example.demo.exception.NoCustomerExistException;
import com.example.demo.model.entity.Customer;
import com.example.demo.model.entity.CustomerSale;
import com.example.demo.model.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    //getCustomer
    @Transactional(propagation = Propagation.SUPPORTS)
    public Customer getCustomer(String mobileNo){

        Customer customer = repository.getCustomerByMobileNo(mobileNo);

        if(customer == null)
            throw new NoCustomerExistException("No such customer exist with mobile no "+mobileNo);
        return customer;
    }


    //registerCustomer
    @Transactional(propagation = Propagation.REQUIRED)
    public Customer registerCustomer(Customer customer){

        // check already present
        Customer cust = repository.getCustomerByMobileNo(customer.getMobile_no());

        //if present, update
        if(cust != null)
            return repository.updateCustomer(cust);

        // if not present , save new
        CustomerSale sale = new CustomerSale();
        customer.setSale(sale);

        return repository.addCustomer(customer);
    }
}
