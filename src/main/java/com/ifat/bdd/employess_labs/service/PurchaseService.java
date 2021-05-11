package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Purchase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PurchaseService {

    //LAB10_a
    public static Map<String, Integer> buildCustomersPaymentsSum(List<Purchase> purchases){
        return purchases.stream().collect(Collectors.groupingBy(p -> p.getCustomerName(),
                Collectors.summingInt(p->p.getProduct().getPrice())));

    }
    //LAB10_b
    public static Map<String,Long>buildCustomersPaymentsCount(List<Purchase> purchases){
        return purchases.stream().collect(Collectors.groupingBy(p -> p.getCustomerName(),
                Collectors.counting()));

    }



}
