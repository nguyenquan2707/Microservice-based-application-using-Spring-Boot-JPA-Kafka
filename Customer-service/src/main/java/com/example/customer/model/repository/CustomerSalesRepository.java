package com.example.customer.model.repository;

import com.example.customer.exceptions.NoCustomerExistException;
import com.example.customer.model.dao.ICustomerDao;
import com.example.customer.model.dao.ICustomerSaleDao;
import com.example.customer.model.entity.Customer;
import com.example.customer.model.entity.CustomerSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
@Repository
public class CustomerSalesRepository implements ICustomerSaleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    ICustomerDao iCustomerDao;

    @Override
    public CustomerSale getSale(String mobileNo) throws NoCustomerExistException {

        //get customer from customer table
        Customer customer = iCustomerDao.getCustomer(mobileNo);

        if(customer == null)
            throw new NoCustomerExistException("No such customer exist with mobile no "+mobileNo);

        //get customerId
        long customerId = customer.getId();
        //get sale info
        return entityManager.find(CustomerSale.class, customerId);
    }

    @Override
    public CustomerSale updateSale(CustomerSale customerSale) throws NoCustomerExistException{

        //check if any sale info exist
        if(entityManager.find(CustomerSale.class, customerSale.getCustomer_id()) == null)
            throw new NoCustomerExistException("No such customer exist with id : "+customerSale.getCustomer_id());

        //if exist then update
        return entityManager.merge(customerSale);
    }

}
