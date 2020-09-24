package com.example.demo.model.repository;

import com.example.demo.model.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Transactional
@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer addCustomer(Customer customer) {

        entityManager.persist(customer);

        return customer;
    }

    public Customer deleteCustomer(String mobileNo) {

        Customer customer = getCustomerByMobileNo(mobileNo);

        if(customer == null)
            return null;

        entityManager.remove(customer);

        return customer;
    }

    public Customer getCustomerByMobileNo(String mobileNo) {

        Query query = entityManager.createQuery("Select c from Customer c where c.mobile_no = "+mobileNo);

        Customer customer = (Customer) query.getResultList().stream().findFirst().orElse(null);

        return customer;
    }

    public Customer getCustomerById(long id) {

        Customer customer = entityManager.find(Customer.class, id);

        return customer;
    }


    public Customer updateCustomer(Customer customer) {

        Customer cus = getCustomerById(customer.getId());

        cus.setAddress(customer.getAddress());
        cus.setName(customer.getName());

        return entityManager.merge(cus);
    }

}
