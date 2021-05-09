package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Employee;
import com.ifat.bdd.employess_labs.model.Gender;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeStatisticsTest {
    private List<Employee> listOfEmployees1;
    private List<Employee> listOfEmployees2;


    @Before
    public void createListOfEmployees() {
        listOfEmployees1 = List
                .of(Employee.builder().firstName("DANNY").lastName("Harel").salary(200).gender(Gender.MAN).build(),
                        Employee.builder().firstName("Daniela").lastName("Harel").salary(300).gender(Gender.WOMAN).build(),
                        Employee.builder().firstName("Ran").lastName("Barel").salary(150).gender(Gender.MAN).build(),
                        Employee.builder().firstName("RINA").lastName("Barel").salary(350).gender(Gender.WOMAN).build());

        listOfEmployees2 = List
                .of(Employee.builder().firstName("DANNY").lastName("Harel").salary(400).gender(Gender.MAN).build(),
                        Employee.builder().firstName("Daniela").lastName("Harel").salary(200).gender(Gender.WOMAN).build(),
                        Employee.builder().firstName("Ran").lastName("Barel").salary(350).gender(Gender.MAN).build(),
                        Employee.builder().firstName("RINA").lastName("Barel").salary(250).gender(Gender.WOMAN).build());

    }

    @Test
    public void TestIsManEmployeesMoreExpensive() {
        boolean isManMoreExpensive1 = EmployeeStatistics.isManEmployeesMoreExpensive(listOfEmployees1);
        System.out.println("isManMoreExpensive1 = " + isManMoreExpensive1);
        Assert.assertFalse(isManMoreExpensive1);
        boolean isManMoreExpensive2 = EmployeeStatistics.isManEmployeesMoreExpensive(listOfEmployees2);
        System.out.println("isManMoreExpensive2 = " + isManMoreExpensive2);
        Assert.assertTrue(isManMoreExpensive2);
    }











}