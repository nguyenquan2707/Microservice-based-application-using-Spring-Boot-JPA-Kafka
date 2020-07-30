package com.example.customer.model.dao;

import com.example.customer.exceptions.NoCustomerExistException;
import com.example.customer.model.entity.CustomerSale;

public interface ICustomerSaleDao {

    CustomerSale getSale(String mobileNo) throws NoCustomerExistException;

    CustomerSale updateSale(CustomerSale customerSale) throws NoCustomerExistException;
}
