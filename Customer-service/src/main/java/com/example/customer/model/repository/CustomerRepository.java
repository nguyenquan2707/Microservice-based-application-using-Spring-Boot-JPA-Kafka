package com.example.customer.model.repository;

import com.example.customer.model.dao.ICustomerDao;
import com.example.customer.model.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class CustomerRepository implements ICustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer addCustomer(Customer customer) {

        entityManager.persist(customer);

        return customer;
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
