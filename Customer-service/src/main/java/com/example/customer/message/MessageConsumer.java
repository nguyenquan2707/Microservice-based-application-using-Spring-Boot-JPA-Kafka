package com.example.customer.message;

import com.example.customer.model.dao.ICustomerSaleDao;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    ICustomerSaleDao iCustomerSaleDao;

    @KafkaListener(topics = TOPIC_UPDATE_SALE_INFO)
    void regCustomerCallback(String message){

        try {
            CustomerSale sale = objectMapper.readValue(message, CustomerSale.class);

            iCustomerSaleDao.updateSale(sale);

        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(),e);
        }

    }
}
