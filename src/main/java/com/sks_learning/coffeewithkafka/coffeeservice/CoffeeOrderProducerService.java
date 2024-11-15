package com.sks_learning.coffeewithkafka.coffeeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CoffeeOrderProducerService {

    private static final String coffeeTopic = "coffeeTopic";
    private static final Logger log = LoggerFactory.getLogger(CoffeeOrderProducerService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public CoffeeOrderProducerService(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(String coffeeTopic,String order){
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(coffeeTopic, order);

        future.whenComplete((result, exception)->{
            if(exception==null){
                log.info("Send order=[{}] with offset=[{}]", order, result.getRecordMetadata().offset());
            }else {
                log.error("Unable to send the order [{}] due to :{}", order, exception.getMessage());
            }
        });
    }

}
