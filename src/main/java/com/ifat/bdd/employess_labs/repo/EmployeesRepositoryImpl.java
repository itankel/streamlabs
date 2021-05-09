package com.ifat.bdd.employess_labs.repo;

import com.ifat.bdd.employess_labs.model.Employee;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesRepositoryImpl implements  EmployeesRepository {

    private final String repositoryFileName;
    EmployeesRepositoryImpl(String csvDataFileName){
        this.repositoryFileName=csvDataFileName;
    }

    @SneakyThrows
    @Override
    public List<Employee> getAllEmployees() {
        return new BufferedReader(new FileReader(repositoryFileName))
                .lines()
                .map(this::convertLineToEmployee)
                .collect(Collectors.toList());
    }


    private Employee convertLineToEmployee(String line){
        String[] employeeRowData = line.split(",");
        return Employee.builder().firstName(employeeRowData[EmployeeAttributesIdentifier.FIRSTNAME.ordinal()])
                .lastName(employeeRowData[EmployeeAttributesIdentifier.LASTNAME.ordinal()])
                .salary(Integer.parseInt(employeeRowData[EmployeeAttributesIdentifier.SALARY.ordinal()].trim()))
                .build();

    }
}
