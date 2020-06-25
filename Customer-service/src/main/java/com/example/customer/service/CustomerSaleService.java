package com.example.customer.service;

import com.example.customer.model.dao.ICustomerSaleDao;
import com.example.customer.model.entity.Customer;
import com.example.customer.model.entity.CustomerSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSaleService {

    @Autowired
    ICustomerSaleDao saleDao;

    //getTotalSale
    public int getTotalSale(String mobileNo){

        return saleDao.getSale(mobileNo).getTotal_sale();
    }


    //updateSale
    public Customer updateTotalSale(Customer customer){

        CustomerSale customerSale = saleDao.updateSale(customer.getSale());
        customer.setSale(customerSale);

        return customer;
    }
}
