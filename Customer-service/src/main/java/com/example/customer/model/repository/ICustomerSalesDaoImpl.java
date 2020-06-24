package com.example.customer.model.repository;

import com.example.customer.model.dao.ICustomerSaleDao;
import com.example.customer.model.entity.CustomerSale;
import org.springframework.stereotype.Repository;

@Repository
public class ICustomerSalesDaoImpl implements ICustomerSaleDao {

    @Override
    public CustomerSale getCustomerSale(String mobileNo) {
        return null;
    }

    @Override
    public CustomerSale updateCustomerSale(CustomerSale customerSale) {

        return null;
    }
}
