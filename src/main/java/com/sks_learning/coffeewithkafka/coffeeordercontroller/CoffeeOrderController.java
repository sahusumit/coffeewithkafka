package com.sks_learning.coffeewithkafka.coffeeordercontroller;


import com.sks_learning.coffeewithkafka.coffeeservice.CoffeeOrderProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CoffeeOrderController {

    private final CoffeeOrderProducerService producerService;
    private String orderTopic = "coffeeTopic";
    public CoffeeOrderController(CoffeeOrderProducerService producerService){
        this.producerService = producerService;
    }

    @GetMapping("/placeOrder")
    public String orderCoffee(@RequestParam Map<String, Object> orderRequest){
        //String orderString = orderRequest.toString();
        producerService.sendOrder(orderTopic,"test message");
        return "Order has been placed for :" + orderRequest.get("coffeeType");
    }

}
