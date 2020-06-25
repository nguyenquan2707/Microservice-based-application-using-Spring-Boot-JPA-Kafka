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

        entityManager.remove(customer);

        return customer;
    }

    @Override
    public Customer getCustomer(String mobileNo) {

        return entityManager.find(Customer.class, Long.parseLong(mobileNo));
    }

    @Override
    public Customer updateCustomer(Customer customer) {

        Customer cus = getCustomer(customer.getMobile_no());

        cus.setAddress(customer.getAddress());
        cus.setName(customer.getName());

        return entityManager.merge(cus);
    }
}
