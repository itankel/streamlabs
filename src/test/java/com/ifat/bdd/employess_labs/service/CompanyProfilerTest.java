package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Company;
import com.ifat.bdd.employess_labs.model.Employee;
import com.ifat.bdd.employess_labs.model.EmployeeCategory;
import com.ifat.bdd.employess_labs.model.Gender;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class CompanyProfilerTest {
    private List<Company> companies;
    private List<Employee> listOfEmployees;

    @Before
    public void createEmployees() {
        companies = List.of(
                Company.builder().name("CompanyA")
                        .employees(
                                List.of(
                                        Employee.builder().firstName("DANNY").lastName("Harel").salary(20000).gender(Gender.MAN)
                                                .companyName("CompanyA")
                                                .employeeCategory(EmployeeCategory.getEmployeeCategory(20000))
                                                .build(),
                                        Employee.builder().firstName("Daniela").lastName("Harel").salary(13000).gender(Gender.WOMAN)
                                                .companyName("CompanyA")
                                                .employeeCategory(EmployeeCategory.getEmployeeCategory(13000))
                                                .build(),
                                        Employee.builder().firstName("Ran").lastName("Barel").salary(15000).gender(Gender.MAN)
                                                .companyName("CompanyA")
                                                .employeeCategory(EmployeeCategory.getEmployeeCategory(15000))
                                                .build(),
                                        Employee.builder().firstName("Tom").lastName("Levi").salary(13500).gender(Gender.WOMAN)
                                                .companyName("CompanyA")
                                                .employeeCategory(EmployeeCategory.getEmployeeCategory(13500))
                                                .build(),
                                        Employee.builder().firstName("Tamar").lastName("Luria").salary(12500).gender(Gender.WOMAN)
                                                .companyName("CompanyA")
                                                .employeeCategory(EmployeeCategory.getEmployeeCategory(12500))
                                                .build()))
                        .build(),
                Company.builder().name("CompanyB").employees(
                        List.of(Employee.builder()
                                        .firstName("RINA").lastName("Barel").salary(35000).gender(Gender.WOMAN)
                                        .companyName("CompanyB")
                                        .employeeCategory(EmployeeCategory.getEmployeeCategory(35000))
                                        .build(),
                                Employee.builder().firstName("Ben").lastName("Sara").salary(20000).gender(Gender.MAN)
                                        .companyName("CompanyB")
                                        .employeeCategory(EmployeeCategory.getEmployeeCategory(20000))
                                        .build(),
                                Employee.builder().firstName("Aviv").lastName("Yardeni").salary(13000).gender(Gender.WOMAN)
                                        .companyName("CompanyB")
                                        .employeeCategory(EmployeeCategory.getEmployeeCategory(13000))
                                        .build(),
                                Employee.builder().firstName("Limor").lastName("Evyatar").salary(22000).gender(Gender.MAN)
                                        .companyName("CompanyB")
                                        .employeeCategory(EmployeeCategory.getEmployeeCategory(22000))
                                        .build()))
                        .build());
    }

    @Test
    @Ignore // still need to make it work
    public void TestCategorize() {

        CompanyProfiler.categorize(companies);
    }

}