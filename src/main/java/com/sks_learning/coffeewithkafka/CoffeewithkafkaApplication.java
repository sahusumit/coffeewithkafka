package com.sks_learning.coffeewithkafka;

import com.sks_learning.coffeewithkafka.coffeeservice.CoffeeOrderConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeewithkafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeewithkafkaApplication.class, args);
	}

}
