package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Company;
import com.ifat.bdd.employess_labs.model.Employee;
import com.ifat.bdd.employess_labs.model.EmployeeCategory;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompanyProfiler {

    public static void categorize(List<Employee> employees) {

        Comparator<Employee> employeeComp = Comparator.comparing(Employee::getEmployeeCategory);
        Map<String, Optional<Employee>> d = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCompanyName
                        , Collectors.maxBy(employeeComp)));

        System.out.println("d = " + d);
        Map<String, Employee> d2 = employees.stream().collect(Collectors.toMap(Employee::getCompanyName, Function.identity(),
                BinaryOperator.maxBy(employeeComp)));
        System.out.println("d2 = " + d2);
    }
}
