package com.ifat.bdd.employess_labs.repo;

public class EmployeesRepositoryManager {
    private static final String EMPLOYEES_REPO_FILE_NAME="data\\employees_data.csv";
    private EmployeesRepository employeesRepository;

    public EmployeesRepositoryManager(){
        employeesRepository = new EmployeesRepositoryImpl(EMPLOYEES_REPO_FILE_NAME);
    }

    public EmployeesRepository getEmployeesRepository(){
        return  employeesRepository;
    }

}
