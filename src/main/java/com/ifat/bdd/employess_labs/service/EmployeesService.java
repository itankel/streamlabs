package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Employee;
import com.ifat.bdd.employess_labs.model.EmployeeCategory;
import com.ifat.bdd.employess_labs.model.Gender;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EmployeesService {

    //LAB1
    public static int calculateEmployeesTotalSalary(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getSalary)
                .mapToInt(i -> i)
                .sum();

    }

    //LAB2
    public static int calculateSalaryOfAllEmployeesPerYear(List<Employee> employees){
        return employees.stream()
                .flatMap(e -> Arrays.stream(e.getSalaries()).boxed()).mapToInt(i -> i).sum();
    }


    //LAB4
    public static String listOfEmployeesNamesCommaSeparated(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getFirstName)
                .collect(Collectors.joining(","));
    }

    //LAB5
    public static List<String> listOfEmployeesNamesSortedByLength(List<Employee> employees) {
        return employees.stream()
                .filter(s -> s.getFirstName().toUpperCase().equals(s.getFirstName()))
                .map(Employee::getFirstName)
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    //LAB6
    public static List<String> listOfEmployeesNamesSortedBySalaryExpensiveFirst(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
    }

    //LAB7_a
    public static Map<Gender, Integer> calculateSumOfMensSalaryVSSumOfWoman(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.summingInt(Employee::getSalary)));


    }

    //LAB8_a
    public static Map<String, List<Employee>> listEmployeesInEachCompany(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getCompanyName));
    }

    //LAB8_b
    public static Map<String, Long> listEmployeesCountInEachCompany(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getCompanyName,
                Collectors.counting()));
    }

    //LAB9
    public static Map<EmployeeCategory,Long> countEmployeesByCategory(List<Employee> employees){
       return employees.stream()
                .collect(Collectors.groupingBy(emp -> EmployeeCategory.getEmployeeCategory(emp.getSalary()),
                        Collectors.counting()));

    }

    //LAB11
    public static Map<String, Integer> listEmployeesNameWithSalary(List<Employee> employees) {
        return employees.stream().collect(Collectors.toMap(Employee::getFirstName,
                Employee::getSalary));
    }





}

