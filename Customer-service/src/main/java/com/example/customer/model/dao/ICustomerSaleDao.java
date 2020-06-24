package com.example.customer.model.dao;

import com.example.customer.model.entity.CustomerSale;

public interface ICustomerSaleDao {

    CustomerSale getCustomerSale(String mobileNo);

    CustomerSale updateCustomerSale(CustomerSale customerSale);
}
