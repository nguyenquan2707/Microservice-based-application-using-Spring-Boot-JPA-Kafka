package com.example.customer.model.repository;

import com.example.customer.model.dao.ICustomerDao;
import com.example.customer.model.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class ICustomerDaoImpl implements ICustomerDao {

    @Override
    public Customer addCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer deleteCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomer(String mobileNo) {
        return null;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return null;
    }
}
