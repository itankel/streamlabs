package com.ifat.bdd.employess_labs.main;

import com.ifat.bdd.employess_labs.repo.EmployeesRepositoryManager;
import com.ifat.bdd.employess_labs.service.EmployeesService;

public class Main {
    public static void main(String[] args) {
        EmployeesRepositoryManager employeesRepositoryManager = new EmployeesRepositoryManager();
        int totlaSalary = EmployeesService.calculateEmployeesTotalSalary(employeesRepositoryManager.getEmployeesRepository().getAllEmployees());
        System.out.println("Employees total Salary = " + totlaSalary);
    }
}
