package com.ifat.bdd.employess_labs.service;

import com.ifat.bdd.employess_labs.model.Company;
import com.ifat.bdd.employess_labs.model.EmployeeCategory;


import java.util.List;

public class CompanyProfiler {

    public static void categorize(List<Company> companies) {
        companies.forEach(company -> company.setCompanyProfile(calculateCompanyProfile(company)));
    }

    private static EmployeeCategory calculateCompanyProfile(Company company){
        return EmployeesService.countEmployeesByCategory(company.getEmployees())
                .entrySet()
                .stream()
                .max((e1,e2) -> (int)(e1.getValue()-e2.getValue())).get().getKey();

    }

}
