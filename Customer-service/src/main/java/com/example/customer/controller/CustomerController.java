package com.example.customer.controller;

import com.example.customer.exceptions.NoCustomerExistException;
import com.example.customer.model.entity.Customer;
import com.example.customer.model.entity.CustomerSale;
import com.example.customer.model.entity.Response;
import com.example.customer.service.CustomerSaleService;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer/")
public class CustomerController  {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerSaleService customerSaleService;

    @RequestMapping(value = "register", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Customer register(@RequestBody Customer customer){
        return customerService.registerCustomer(customer);
    }

    @RequestMapping(value = "un-register", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Customer unRegister(@RequestBody Customer customer){
        return customerService.unRegisterCustomer(customer);
    }

    @RequestMapping(value = "view/{mobile_no}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Response<Customer>> getCustomer(@PathVariable String mobile_no){

        Response<Customer> response = new Response<>();
        try {
            Customer customer = customerService.getCustomer(mobile_no);

            response.setSuccess(true);
            response.setData(customer);

        } catch (NoCustomerExistException e) {

            response.setSuccess(false);
            response.setMessage(e.toString());

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "sale/view/{mobile_no}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ResponseEntity<Response<CustomerSale>> getSaleInfo(@PathVariable String mobile_no){

        Response<CustomerSale> response = new Response<>();
        try {
            CustomerSale sale = customerSaleService.getTotalSale(mobile_no);

            response.setSuccess(true);
            response.setData(sale);

        } catch (NoCustomerExistException e) {

            response.setSuccess(false);
            response.setMessage(e.toString());

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @RequestMapping(value = "sale/update", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Response<CustomerSale>> updateSaleInfo(@RequestBody CustomerSale customerSale){

        Response<CustomerSale> response = new Response<>();
        try {
            CustomerSale sale = customerSaleService.updateTotalSale(customerSale);

            response.setSuccess(true);
            response.setData(sale);

        } catch (NoCustomerExistException e) {

            response.setSuccess(false);
            response.setMessage(e.toString());

        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
