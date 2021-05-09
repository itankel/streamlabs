package com.ifat.bdd.employess_labs.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Purchase {
    private String customerName;
    private Product product;
}
