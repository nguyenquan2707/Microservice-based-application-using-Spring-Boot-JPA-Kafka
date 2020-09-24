package com.example.demo.model.repository;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.entity.CustomerSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class CustomerSalesRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    CustomerRepository customerRepository;

    public CustomerSale getSale(String mobileNo){

        //get customer from customer table
        Customer customer = customerRepository.getCustomerByMobileNo(mobileNo);

        if(customer == null)
           return null;

        //get customerId
        long customerId = customer.getId();
        //get sale info
        return entityManager.find(CustomerSale.class, customerId);
    }

    public CustomerSale updateSale(CustomerSale customerSale){

        //check if any sale info exist
        if(entityManager.find(CustomerSale.class, customerSale.getCustomer_id()) == null)
            return null;

        //if exist then update
        return entityManager.merge(customerSale);
    }

}
