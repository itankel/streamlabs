package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Employee;
import com.ifat.bdd.employess_labs.model.Gender;

import java.util.List;
import java.util.Map;

public class EmployeeStatistics {
    public static boolean isManEmployeesMoreExpensive(List<Employee> employees) {
        Map<Gender, Integer> sumOfMensVsWoman = EmployeesService.calculateSumOfMensSalaryVSSumOfWoman(employees);
        return sumOfMensVsWoman.get(Gender.MAN) > sumOfMensVsWoman.get(Gender.WOMAN) ? true : false;
    }


}