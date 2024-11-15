package com.sks_learning.coffeewithkafka.coffeeservice;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CoffeeOrderConsumerService {
    private static final Logger log = LoggerFactory.getLogger(CoffeeOrderConsumerService.class);

    @KafkaListener(topics = "coffeeTopic", groupId = "coffee-shop-group")
    public void consumeOrder(String order){
        try {
            log.info("Coffee order received {}", order);
            log.info("Coffee order ready to pick up {}", order);
        } catch (Exception e) {
            log.error("Error processing coffee order: {}", e.getMessage(), e);
        }
    }
}
