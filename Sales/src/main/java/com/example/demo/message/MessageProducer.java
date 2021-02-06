package com.example.demo.message;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.entity.CustomerSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    KafkaTemplate<String, Customer> consumerRegistrationTemplate;

    @Autowired
    KafkaTemplate<String, CustomerSale> consumerSaleUpdateTemplate;

    private final String TOPIC_UPDATE_SALE_INFO ="topic_update_sale";

    private final String TOPIC_REGISTER_NEW_CUSTOMER ="topic_register_new_customer";

    public void produceMessageOnCustomerRegistration(Customer customer){
        consumerRegistrationTemplate.send(TOPIC_REGISTER_NEW_CUSTOMER, customer);
    }

    public void produceMessageOnUpdateCustomerSale(CustomerSale customerSale){
        consumerSaleUpdateTemplate.send(TOPIC_UPDATE_SALE_INFO, customerSale);
    }

}
