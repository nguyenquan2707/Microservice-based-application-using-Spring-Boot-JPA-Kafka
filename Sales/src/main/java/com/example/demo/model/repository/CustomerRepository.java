package com.example.demo.model.repository;

import com.example.demo.model.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(propagation = Propagation.MANDATORY)
    public Customer addCustomer(Customer customer) {

        entityManager.persist(customer);

        return customer;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Customer deleteCustomer(String mobileNo) {

        Customer customer = getCustomerByMobileNo(mobileNo);

        if(customer == null)
            return null;

        entityManager.remove(customer);

        return customer;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Customer getCustomerByMobileNo(String mobileNo) {

        Query query = entityManager.createQuery("Select c from Customer c where c.mobile_no = "+mobileNo);

        Customer customer = (Customer) query.getResultList().stream().findFirst().orElse(null);

        return customer;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public Customer getCustomerById(long id) {

        Customer customer = entityManager.find(Customer.class, id);

        return customer;
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public Customer updateCustomer(Customer customer) {

        Customer cus = getCustomerById(customer.getId());

        cus.setAddress(customer.getAddress());
        cus.setName(customer.getName());

        return entityManager.merge(cus);
    }

}
