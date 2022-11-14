package com.example.customer.handler;

import com.example.customer.exceptions.NoCustomerExistException;
import com.example.customer.model.dao.ICustomerSaleDao;
import com.example.customer.model.entity.CustomerSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
public class CustomerSaleService {

    @Autowired
    ICustomerSaleDao saleDao;

    //getTotalSale
    public CustomerSale getTotalSale(String mobileNo) {

        CustomerSale sale = saleDao.getSale(mobileNo);

        if(sale ==  null)
            throw new NoCustomerExistException("No record found for customer with mobile no : "+mobileNo);

        return sale;

    }


    //updateSale
    public CustomerSale updateTotalSale(CustomerSale customerSale) {

        CustomerSale sale = saleDao.updateSale(customerSale);

        if(sale == null)
            throw new NoCustomerExistException("No record found for customer with id : "+customerSale.getCustomer_id());

        return sale;
    }
}
