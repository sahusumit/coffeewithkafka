package com.sks_learning.coffeewithkafka.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoffeeOrder {
    private String coffeeType;
    private String size;
    private String milk;
}
