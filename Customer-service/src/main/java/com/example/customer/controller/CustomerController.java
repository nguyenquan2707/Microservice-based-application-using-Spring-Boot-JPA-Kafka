package com.example.customer.controller;

import com.example.customer.model.entity.Customer;
import com.example.customer.model.entity.CustomerSale;
import com.example.customer.model.entity.Response;
import com.example.customer.handler.CustomerSaleService;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController  {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerSaleService customerSaleService;

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Customer register(@Valid @RequestBody Customer customer){
        return customerService.registerCustomer(customer);
    }

    @RequestMapping(value = "/{mobile_no}",produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
    public Customer unRegister(@PathVariable String mobile_no){
        return customerService.unRegisterCustomer(mobile_no);
    }

    @RequestMapping(value = "/{mobile_no}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Response<Customer>> getCustomer(@PathVariable String mobile_no){

        Response<Customer> response = new Response<>();

        Customer customer = customerService.getCustomer(mobile_no);

        response.setSuccess(true);
        response.setData(customer);


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/sale/{mobile_no}", produces = MediaType.APPLICATION_JSON_VALUE, method =
            RequestMethod.GET)
    public ResponseEntity<Response<CustomerSale>> getSaleInfo(@PathVariable String mobile_no){

        Response<CustomerSale> response = new Response<>();

        CustomerSale sale = customerSaleService.getTotalSale(mobile_no);

        response.setSuccess(true);
        response.setData(sale);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @RequestMapping(value = "/sale", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Response<CustomerSale>> updateSaleInfo(@Valid @RequestBody CustomerSale customerSale){

        Response<CustomerSale> response = new Response<>();

        CustomerSale sale = customerSaleService.updateTotalSale(customerSale);

        response.setSuccess(true);
        response.setData(sale);


        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
