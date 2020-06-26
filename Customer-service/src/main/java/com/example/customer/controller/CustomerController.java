package com.example.customer.controller;

import com.example.customer.model.entity.Customer;
import com.example.customer.service.CustomerSaleService;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/")
public class CustomerController  {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerSaleService saleService;

    @RequestMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Customer register(@RequestBody Customer customer){
      return customerService.registerCustomer(customer);
    }

    @RequestMapping(value = "un-register", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Customer unRegister(@RequestBody Customer customer){
        return customerService.unRegisterCustomer(customer);
    }

    @RequestMapping(value = "view/{mobile_no}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable String mobile_no){
        return customerService.getCustomer(mobile_no);
    }

    @RequestMapping(value = "sale/view/{mobile_no}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public int getSaleInfo(@PathVariable String mobile_no){
        return saleService.getTotalSale(mobile_no);
    }

    @RequestMapping(value = "sale/update", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public Customer updateSaleInfo(@RequestBody Customer customer){
        return saleService.updateTotalSale(customer);
    }

  }
