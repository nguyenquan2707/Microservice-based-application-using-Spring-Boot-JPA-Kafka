package com.example.customer.model.dao;

import com.example.customer.model.entity.Customer;

public interface ICustomerDao {

    Customer addCustomer(Customer customer);

    Customer deleteCustomer(Customer customer);

    Customer getCustomer(String mobileNo);

    Customer updateCustomer(Customer customer);
}
