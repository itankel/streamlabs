package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Product;
import com.ifat.bdd.employess_labs.model.Purchase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class PurchaseServiceTest {

    private List<Purchase> purchases;

    @Before
    public void createPurchase() {
        this.purchases = List.of(Purchase.builder().customerName("Ron Bar")
                        .product(
                                Product.builder().name("phone").price(800).build()
                        ).build(),
                Purchase.builder().customerName("kiki")
                        .product(
                                Product.builder().name("Phone").price(701).build()
                        ).build(),
                Purchase.builder().customerName("kiki")
                        .product(
                                Product.builder().name("Phone").price(701).build()
                        ).build(),
                Purchase.builder().customerName("Ron Bar")
                        .product(
                                Product.builder().name("Bag").price(150).build()
                        ).build(),
                Purchase.builder().customerName("kiki")
                        .product(
                                Product.builder().name("Bag").price(100).build()
                        ).build());
    }


    @Test
    public void TestBuildCustomersPaymentsSum() {
        Map<String, Integer> expected = this.purchases.stream().collect(Collectors.groupingBy(Purchase::getCustomerName,
                Collectors.summingInt(p -> p.getProduct().getPrice())));
        System.out.println("expected = " + expected);
        Map<String, Integer> actualVal = PurchaseService.buildCustomersPaymentsSum(this.purchases);
        System.out.println("actualVal = " + actualVal);
        Assert.assertEquals(expected.size(),actualVal.size());
        for (String key: expected.keySet()) {
            assertEquals(expected.get(key) ,actualVal.get(key));
        }
    }


    @Test
    public void TestBuildCustomersPaymentsCount() {
        Map<String, Long> expected = this.purchases.stream().collect(Collectors.groupingBy(Purchase::getCustomerName,
                Collectors.counting()));
        System.out.println("expected = " + expected);
        Map<String, Long> actualVal = PurchaseService.buildCustomersPaymentsCount(this.purchases);
        System.out.println("actualVal = " + actualVal);
        Assert.assertEquals(expected.size(),actualVal.size());
        for (String key: expected.keySet()) {
            assertEquals(expected.get(key) ,actualVal.get(key));
        }
    }



}