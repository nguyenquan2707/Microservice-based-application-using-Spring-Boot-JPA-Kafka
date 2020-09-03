package com.example.customer.model.dao;

import com.example.customer.exceptions.NoCustomerExistException;
import com.example.customer.model.entity.Customer;

public interface ICustomerDao {

    Customer addCustomer(Customer customer);

    Customer deleteCustomer(String mobileNo);

    Customer getCustomer(String mobileNo) throws NoCustomerExistException;

    Customer updateCustomer(Customer customer);
}
