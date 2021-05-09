package com.ifat.bdd.employess_labs.model;

import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private String firstName;
    private String lastName;
    private Gender gender;
    private String companyName;
    private EmployeeCategory employeeCategory;
    private int salary;
    private int[] salaries = new int[12];
}
