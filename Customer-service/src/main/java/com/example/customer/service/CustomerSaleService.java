package com.example.customer.service;

import com.example.customer.model.dao.ICustomerSaleDao;
import com.example.customer.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSaleService {

    @Autowired
    ICustomerSaleDao saleDao;

    //getTotalSale
    public int getTotalSale(String mobileNo){

        return saleDao.getCustomerSale(mobileNo).getTotal_sale();
    }


    //updateSale
    public int updateTotalSale(Customer customer){

        return saleDao.updateCustomerSale(customer.getSale()).getTotal_sale();
    }
}
