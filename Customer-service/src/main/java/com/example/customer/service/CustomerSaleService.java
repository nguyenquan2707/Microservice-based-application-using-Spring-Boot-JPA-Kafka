package com.example.customer.service;

import com.example.customer.exceptions.NoCustomerExistException;
import com.example.customer.model.dao.ICustomerDao;
import com.example.customer.model.dao.ICustomerSaleDao;
import com.example.customer.model.entity.Customer;
import com.example.customer.model.entity.CustomerSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSaleService {

    @Autowired
    ICustomerSaleDao saleDao;

    @Autowired
    ICustomerDao customerDao;

    //getTotalSale
    public CustomerSale getTotalSale(String mobileNo) throws NoCustomerExistException {

        CustomerSale sale = saleDao.getSale(mobileNo);

        return sale;

    }


    //updateSale
    public CustomerSale updateTotalSale(CustomerSale customerSale) throws NoCustomerExistException{

        CustomerSale sale = saleDao.updateSale(customerSale);

        return sale;
    }
}
