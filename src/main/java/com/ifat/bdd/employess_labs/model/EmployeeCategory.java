package com.ifat.bdd.employess_labs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;

@AllArgsConstructor
public enum EmployeeCategory {
    JUNIORS(0,13999),
    MIDDLE(14000,20999),
    SENIORS(21000,Integer.MAX_VALUE);

    private final int min;
    private final int max;

    public static EmployeeCategory getEmployeeCategory(int salary){
        return Arrays.stream(EmployeeCategory.values())
                .filter(v->v.max>=salary )
                .filter(v->v.min<=salary)
                .findFirst()
                .orElseThrow(()-> new RuntimeException("cannot choose the right Category"));

    }
}
