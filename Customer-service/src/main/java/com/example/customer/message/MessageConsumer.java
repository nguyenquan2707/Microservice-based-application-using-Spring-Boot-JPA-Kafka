package com.example.customer.message;

import com.example.customer.model.dao.ICustomerDao;
import com.example.customer.model.dao.ICustomerSaleDao;
import com.example.customer.model.entity.Customer;
import com.example.customer.model.entity.CustomerSale;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    private final String TOPIC_UPDATE_SALE_INFO ="updateSaleInfoCallback";

    private final String TOPIC_REGISTER_NEW_CUSTOMER ="regNewCustomerCallback";


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    ICustomerSaleDao iCustomerSaleDao;

    @Autowired
    ICustomerDao iCustomerDao;

    @KafkaListener(topics = TOPIC_UPDATE_SALE_INFO)
    void updateSaleInfoCallback(String message){

        try {
            CustomerSale sale = objectMapper.readValue(message, CustomerSale.class);

            iCustomerSaleDao.updateSale(sale);

        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(),e);
        }

    }

    @KafkaListener(topics = TOPIC_REGISTER_NEW_CUSTOMER)
    void regNewCustomerCallback(String message){

        try {
            Customer customer = objectMapper.readValue(message, Customer.class);

            iCustomerDao.addCustomer(customer);

        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(),e);
        }

    }
}
