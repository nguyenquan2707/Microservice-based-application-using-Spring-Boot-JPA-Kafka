package com.example.customer.model.dao;

import com.example.customer.model.entity.CustomerSale;

public interface ICustomerSaleDao {

    CustomerSale getSale(String mobileNo);

    CustomerSale updateSale(CustomerSale customerSale);
}
