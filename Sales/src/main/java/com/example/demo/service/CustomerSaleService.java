package com.example.demo.service;

import com.example.demo.exception.NoCustomerExistException;
import com.example.demo.model.entity.CustomerSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSaleService {

    @Autowired
    CustomerSaleService saleService;

    //getTotalSale
    public CustomerSale getTotalSale(String mobileNo) {

        CustomerSale sale = saleService.getTotalSale(mobileNo);

        if(sale ==  null)
            throw new NoCustomerExistException("No record found for customer with mobile no : "+mobileNo);

        return sale;

    }


    //updateSale
    public CustomerSale updateTotalSale(CustomerSale customerSale) {

        CustomerSale sale = saleService.updateTotalSale(customerSale);

        if(sale == null)
            throw new NoCustomerExistException("No record found for customer with id : "+customerSale.getCustomer_id());

        return sale;
    }
}
