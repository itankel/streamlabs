package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Employee;
import com.ifat.bdd.employess_labs.model.Gender;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeesService {

    public static int calculateEmployeesTotalSalary(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .mapToInt(i -> i)
                .sum();

    }


    public static String listOfEmployeesNamesCommaSeparated(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getFirstName)
                .collect(Collectors.joining(","));
    }


    public static List<String> listOfEmployeesNamesSortedByLength(List<Employee> employees) {
        return employees.stream()
                .filter(s -> s.getFirstName().toUpperCase().equals(s.getFirstName()))
                .map(Employee::getFirstName)
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> listOfEmployeesNamesSortedBySalaryExpensiveFirst(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
    }


    public static Map<Gender, Integer> calculateSumOfMensSalaryVSSumOfWoman(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.summingInt(Employee::getSalary)));


    }

    public static Map<String, List<Employee>> listEmployeesInEachCompany(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getCompanyName));
    }


    public static Map<String, Long> listEmployeesCountInEachCompany(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getCompanyName,
                Collectors.counting()));
    }


    public static Map<String, Integer> listEmployeesNameWithSalary(List<Employee> employees) {
        return employees.stream().collect(Collectors.toMap(Employee::getFirstName,
                Employee::getSalary));
    }
}

