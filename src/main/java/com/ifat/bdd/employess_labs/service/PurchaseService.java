package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Product;
import com.ifat.bdd.employess_labs.model.Purchase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PurchaseService {

    public static void buildCustomersPaymentsMap(List<Purchase> purchases, List<Product> products){
        Map<String, Integer> a = purchases.stream().collect(Collectors.toMap(p -> p.getCustomerName(),
                purchase -> purchase.getProduct().getPrice()));

    }

}
