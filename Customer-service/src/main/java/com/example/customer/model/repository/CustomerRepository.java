package com.example.customer.model.repository;

import com.example.customer.model.dao.ICustomerDao;
import com.example.customer.model.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
@Repository
public class CustomerRepository implements ICustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Customer addCustomer(Customer customer) {

        entityManager.merge(customer);

        return customer;
    }

    @Override
    public Customer deleteCustomer(String mobileNo) {

        Customer customer = getCustomer(mobileNo);

        if(customer == null)
            return null;

        entityManager.remove(customer);

        return customer;
    }

    @Override
    public Customer getCustomer(String mobileNo) {

        Query query = entityManager.createQuery("Select c from Customer c where c.mobile_no = "+mobileNo);

        Customer customer = (Customer) query.getResultList().stream().findFirst().orElse(null);

        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {

        Customer cus = getCustomer(customer.getMobile_no());

        cus.setAddress(customer.getAddress());
        cus.setName(customer.getName());

        return entityManager.merge(cus);
    }
}
