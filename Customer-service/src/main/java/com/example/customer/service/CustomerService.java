package com.example.customer.service;


import com.example.customer.model.dao.ICustomerDao;
import com.example.customer.model.entity.Customer;
import com.example.customer.model.entity.CustomerSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    ICustomerDao customerDao;

    //getCustomer
    public Customer getCustomer(String mobileNo){

        return customerDao.getCustomer(mobileNo);
    }


    //registerCustomer
    public Customer registerCustomer(Customer customer){

        /*
        * Post post = new Post();
post.setTitle("High-Performance Java Persistence");

PostDetails details = new PostDetails();
details.setCreatedBy("Vlad Mihalcea");

post.setDetails(details);

entityManager.persist(post);
        *
        * */

        CustomerSale customerSale = customer.getSale();
        customer.setSale(customerSale);

        return customerDao.addCustomer(customer);
    }

    //unregisterCustomer
    public Customer unRegisterCustomer(Customer customer){

        return customerDao.deleteCustomer(customer);
    }
}
