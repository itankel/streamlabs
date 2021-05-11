package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Employee;
import com.ifat.bdd.employess_labs.model.EmployeeCategory;
import com.ifat.bdd.employess_labs.model.Gender;
import lombok.Getter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public void TestCalculateSalaryOfAllEmployeesPerYear() {
        int[] salaries1 = new int[12];
        salaries1 = new int[]{10000, 20000, 15000, 40000, 15000, 20000, 15000, 18000, 19000, 10000};
        int[] salaries2 = new int[12];
        salaries2 = new int[]{10001, 20001, 15001, 40001, 15001, 20001, 15001, 18001, 19001, 10001};
        int[] salaries3 = new int[12];
        salaries3 = new int[]{10002, 20002, 15002, 40002, 15002, 20002, 15002, 18002, 19002, 10002};
        List<Employee> listOfEmployees2 = List
                .of(Employee.builder().firstName("DANNY").lastName("Harel").salary(20000).gender(Gender.MAN)
                                .companyName("CompanyA").employeeCategory(EmployeeCategory.getEmployeeCategory(20000))
                                .salaries(salaries1).build(),
                        Employee.builder().firstName("Daniela").lastName("Harel").salary(30000).gender(Gender.WOMAN)
                                .companyName("CompanyA").employeeCategory(EmployeeCategory.getEmployeeCategory(30000))
                                .salaries(salaries2).build(),
                        Employee.builder().firstName("Ran").lastName("Barel").salary(15000).gender(Gender.MAN)
                                .companyName("CompanyA").employeeCategory(EmployeeCategory.getEmployeeCategory(15000))
                                .salaries(salaries3).build());
        int expectedSum = listOfEmployees2.stream().flatMap(e -> Arrays.stream(e.getSalaries()).boxed()).mapToInt(e -> e).sum();

        int total = EmployeesService.calculateSalaryOfAllEmployeesPerYear(listOfEmployees2);
        Assert.assertEquals(expectedSum, total);
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

    @Test
    public void TestCountEmployeesByCategory() {
        List<Employee> companyEmployees = List
                .of(Employee.builder().firstName("DANNY").lastName("Harel").salary(20000).gender(Gender.MAN)
                                .companyName("CompanyA")
                                .employeeCategory(EmployeeCategory.getEmployeeCategory(20000))
                                .build(),
                        Employee.builder().firstName("Daniela").lastName("Harel").salary(30000).gender(Gender.WOMAN)
                                .companyName("CompanyA")
                                .employeeCategory(EmployeeCategory.getEmployeeCategory(30000))
                                .build(),
                        Employee.builder().firstName("Ran").lastName("Barel").salary(15000).gender(Gender.MAN)
                                .companyName("CompanyA").employeeCategory(EmployeeCategory.getEmployeeCategory(15000))
                                .build());

        System.out.println("companyEmployees = " + companyEmployees);
        Map<EmployeeCategory, Long> expectedCounts = companyEmployees.stream().collect(Collectors.groupingBy(employee -> employee.getEmployeeCategory(),
                Collectors.counting()));
        System.out.println("expectedCounts = " + expectedCounts);
        Map<EmployeeCategory, Long> actualCount = EmployeesService.countEmployeesByCategory(companyEmployees);

        System.out.println("actualCount = " + actualCount);
        Assert.assertEquals(expectedCounts.size(), actualCount.size());
        for (EmployeeCategory employeeCategory : actualCount.keySet()) {
            Assert.assertEquals(expectedCounts.get(employeeCategory), actualCount.get(employeeCategory));
        }
    }


    @Test()
    //@Ignore  // not working yet need to check
    public void TestListEmployeesNameWithSalary() {
        Map<String, Integer> expectedEmployeesSalary = listOfEmployees.stream()
                .collect(Collectors.toMap(Employee::getFirstName,Employee::getSalary));
        System.out.println("expectedEmployeesSalary = " + expectedEmployeesSalary);
        Map<String, Integer> employeesNameAndSalaries = EmployeesService.listEmployeesNameWithSalary(listOfEmployees);
        System.out.println("employeesNameAndSalaries = " + employeesNameAndSalaries);
        for (String employee : employeesNameAndSalaries.keySet()) {
            Assert.assertEquals(expectedEmployeesSalary.get(employee), employeesNameAndSalaries.get(employee));
        }
    }

    // in case there are 2 names the same there is thow exception
    @Test(expected=IllegalStateException.class)
    public void TestListEmployeesNameWithSalaryDuplicateData() {
        List<Employee> listOfEmployees1 = List
                .of(Employee.builder().firstName("DANNY").lastName("Harel").salary(200).gender(Gender.MAN)
                                .companyName("CompanyA").build(),
                        Employee.builder().firstName("Daniela").lastName("Harel").salary(300).gender(Gender.WOMAN)
                                .companyName("CompanyA").build(),
                        Employee.builder().firstName("Ran").lastName("Barel").salary(150).gender(Gender.MAN)
                                .companyName("CompanyA").build(),
                        Employee.builder().firstName("Ran").lastName("Barel").salary(350).gender(Gender.WOMAN)
                                .companyName("CompanyB").build());

        Map<String, Integer> expectedEmployeesSalary = listOfEmployees1.stream()
                .collect(Collectors.toMap(Employee::getFirstName,Employee::getSalary));
        System.out.println("expectedEmployeesSalary = " + expectedEmployeesSalary);
        Map<String, Integer> employeesNameAndSalaries = EmployeesService.listEmployeesNameWithSalary(listOfEmployees1);
        System.out.println("employeesNameAndSalaries = " + employeesNameAndSalaries);
        for (String employee : employeesNameAndSalaries.keySet()) {
            Assert.assertEquals(expectedEmployeesSalary.get(employee), employeesNameAndSalaries.get(employee));
        }
    }
}