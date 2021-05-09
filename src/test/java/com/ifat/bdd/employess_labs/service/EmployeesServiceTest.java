package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Employee;
import com.ifat.bdd.employess_labs.model.Gender;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeesServiceTest {
    private List<Employee> listOfEmployees;


    @Before
    public void createListOfEmployees() {
        listOfEmployees = List
                .of(Employee.builder().firstName("DANNY").lastName("Harel").salary(200).gender(Gender.MAN)
                                .companyName("CompanyA").build(),
                        Employee.builder().firstName("Daniela").lastName("Harel").salary(300).gender(Gender.WOMAN)
                                .companyName("CompanyA").build(),
                        Employee.builder().firstName("Ran").lastName("Barel").salary(150).gender(Gender.MAN)
                                .companyName("CompanyA").build(),
                        Employee.builder().firstName("RINA").lastName("Barel").salary(350).gender(Gender.WOMAN)
                                .companyName("CompanyB").build(),
                        Employee.builder().firstName("Ben").lastName("Sara").salary(200).gender(Gender.MAN)
                                .companyName("CompanyB").build(),
                        Employee.builder().firstName("Aviv").lastName("Yardeni").salary(300).gender(Gender.WOMAN)
                                .companyName("CompanyB").build(),
                        Employee.builder().firstName("Limor").lastName("Evyatar").salary(150).gender(Gender.MAN)
                                .companyName("CompanyB").build(),
                        Employee.builder().firstName("Tom").lastName("Levi").salary(350).gender(Gender.WOMAN)
                                .companyName("CompanyC").build(),
                        Employee.builder().firstName("Tamar").lastName("Luria").salary(250).gender(Gender.WOMAN)
                                .companyName("CompanyC").build());
    }

    @Test
    public void TestCalculateEmployeesTotalSalary() {
        int total = EmployeesService.calculateEmployeesTotalSalary(listOfEmployees);
        long expected = listOfEmployees.stream()
                .mapToInt(Employee::getSalary)
                .sum();
        Assert.assertEquals(expected, total);

    }

    @Test
    public void TestListOfEmployeesNamesSeparatedByComma() {
        String listOfNames = EmployeesService.listOfEmployeesNamesCommaSeparated(listOfEmployees);
        String employeesNamesExpected = listOfEmployees.stream().map(Employee::getFirstName).collect(Collectors.joining(","));
        System.out.println("listOfNames = " + listOfNames);
        Assert.assertEquals(employeesNamesExpected, listOfNames);
    }

    @Test
    public void TestListOfEmployeesNamesSortedByLength() {
        List<String> sortedEmployeesNames = EmployeesService.listOfEmployeesNamesSortedByLength(listOfEmployees);
        System.out.println("sortedEmployeesNames = " + sortedEmployeesNames);
        List<String> expectedListNames = listOfEmployees.stream()
                .filter(e -> e.getFirstName().equals(e.getFirstName().toUpperCase()))
                .sorted(Comparator.comparing(e -> e.getFirstName().length()))
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
        System.out.println("expectedListNames = " + expectedListNames);
        Assert.assertArrayEquals(expectedListNames.toArray(), sortedEmployeesNames.toArray());
    }

    @Test
    public void TestListOfEmployeesNamesSortedBySalaryExpensiveFirst() {
        List<String> sortedEmployeesNames = EmployeesService.listOfEmployeesNamesSortedBySalaryExpensiveFirst(listOfEmployees);
        List<String> expectedListNames = listOfEmployees.stream()
                .sorted(Comparator.comparing(Employee::getSalary)
                        .reversed())
                .map(Employee::getFirstName)
                .collect(Collectors.toList());
        System.out.println("sortedEmployeesNames = " + sortedEmployeesNames);
        Assert.assertArrayEquals(expectedListNames.toArray(), sortedEmployeesNames.toArray());
    }

    @Test
    public void TestCalculateSumOfMensSalaryVSSumOfWoman() {
        long expectedMensSalary = listOfEmployees.stream()
                .filter(e -> e.getGender() == Gender.MAN)
                .mapToInt(Employee::getSalary)
                .sum();
        long expectedWomanSalary = listOfEmployees.stream()
                .filter(e -> e.getGender() == Gender.WOMAN)
                .mapToInt(Employee::getSalary)
                .sum();
        Map<Gender, Integer> sumOfMensVsWoman = EmployeesService.calculateSumOfMensSalaryVSSumOfWoman(listOfEmployees);

        System.out.println("sumOfMensVsWoman = " + sumOfMensVsWoman);
        Assert.assertEquals(expectedMensSalary, (long) sumOfMensVsWoman.get(Gender.MAN));
        Assert.assertEquals(expectedWomanSalary, (long) sumOfMensVsWoman.get(Gender.WOMAN));
    }

    @Test
    public void TestListEmployeesInEachCompany() {
        Map<String, List<Employee>> retCompaniesToEmployees = EmployeesService.listEmployeesInEachCompany(listOfEmployees);
        System.out.println("retCompaniesToEmployees = " + retCompaniesToEmployees);
        List<String> companiesNames = listOfEmployees.stream()
                .map(Employee::getCompanyName)
                .distinct()
                .collect(Collectors.toList());
        for (String companyName : companiesNames) {
            List<Employee> companiesEmployees = listOfEmployees.stream()
                    .filter(e -> e.getCompanyName().equals(companyName))
                    .collect(Collectors.toList());
            Assert.assertArrayEquals(companiesEmployees.toArray(), retCompaniesToEmployees.get(companyName).toArray());
        }
    }


    @Test
    public void TestListEmployeesCountInEachCompany() {
        Map<String, Long> retCompaniesToEmployeesCount = EmployeesService.listEmployeesCountInEachCompany(listOfEmployees);
        System.out.println("retCompaniesToEmployeesCount = " + retCompaniesToEmployeesCount);
        List<String> companiesNames = listOfEmployees.stream()
                .map(Employee::getCompanyName)
                .distinct()
                .collect(Collectors.toList());
        for (String companyName : companiesNames) {
            long companiesEmployeesCount = listOfEmployees.stream()
                    .filter(e -> e.getCompanyName().equals(companyName))
                    .count();
            Assert.assertEquals(companiesEmployeesCount, (long) retCompaniesToEmployeesCount.get(companyName));
        }
    }


    @Test()
    @Ignore  // not working yet need to check
    public void TestListEmployeesNameWithSalary() {
        List<String> expectedEmployeesNames =listOfEmployees.stream()
                .map(Employee::getFirstName)
                .collect(Collectors.toList());

        Map<String, Integer> employeesNameAndSalaries = EmployeesService.listEmployeesNameWithSalary(listOfEmployees);
        System.out.println("employeesNameAndSalaries = " + employeesNameAndSalaries);
        Assert.assertArrayEquals(expectedEmployeesNames.toArray(),employeesNameAndSalaries.keySet().toArray());

    }


}