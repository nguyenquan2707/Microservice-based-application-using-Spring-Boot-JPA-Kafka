package com.example.demo.message;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.entity.CustomerSale;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate<String, String> consumerRegistrationTemplate;

    @Autowired
    KafkaTemplate<String, String> consumerSaleUpdateTemplate;

    private final String TOPIC_UPDATE_SALE_INFO ="topic_update_sale";

    private final String TOPIC_REGISTER_NEW_CUSTOMER ="topic_register_new_customer";

    public void produceMessageOnCustomerRegistration(Customer customer){

        String msg = null;
        try {
            msg = objectMapper.writeValueAsString(customer);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        consumerRegistrationTemplate.send(TOPIC_REGISTER_NEW_CUSTOMER, msg);
    }

    public void produceMessageOnUpdateCustomerSale(CustomerSale customerSale){
        String msg = null;
        try {
            msg = objectMapper.writeValueAsString(customerSale);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        consumerSaleUpdateTemplate.send(TOPIC_UPDATE_SALE_INFO, msg);
    }

}
