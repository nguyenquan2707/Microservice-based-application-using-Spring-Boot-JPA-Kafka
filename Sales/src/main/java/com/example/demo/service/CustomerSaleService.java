package com.example.demo.service;

import com.example.demo.exception.NoCustomerExistException;
import com.example.demo.model.entity.CustomerSale;
import com.example.demo.model.repository.CustomerSalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerSaleService {

    @Autowired
    CustomerSalesRepository salesRepository;

    //getTotalSale
    @Transactional(propagation = Propagation.SUPPORTS)
    public CustomerSale getTotalSale(String mobileNo) {

        CustomerSale sale = salesRepository.getSale(mobileNo);

        if(sale ==  null)
            throw new NoCustomerExistException("No record found for customer with mobile no : "+mobileNo);

        return sale;

    }


    //updateSale
    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerSale updateTotalSale(CustomerSale customerSale) {

        CustomerSale sale = salesRepository.updateSale(customerSale);

        if(sale == null)
            throw new NoCustomerExistException("No record found for customer with id : "+customerSale.getCustomer_id());

        return sale;
    }
}
