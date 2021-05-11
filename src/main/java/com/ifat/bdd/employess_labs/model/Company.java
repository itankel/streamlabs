package com.ifat.bdd.employess_labs.model;

import com.ifat.bdd.employess_labs.service.CompanyProfiler;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {

    public Company(List<Employee> employees) {
        this.employees = employees;
    }
    private String name;
    private EmployeeCategory companyProfile;  //defined by biggest employees portion with same EmployeesCategory
    @Singular
    private List<Employee> employees;



}
