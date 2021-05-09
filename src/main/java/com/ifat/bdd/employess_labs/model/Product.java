package com.ifat.bdd.employess_labs.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private String name;
    private int price;
}
