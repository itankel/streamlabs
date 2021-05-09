package com.ifat.bdd.employess_labs.repo;

import com.ifat.bdd.employess_labs.model.Employee;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;



public class EmployeesRepositoryImplTest {

    @Test
    public void TestGetAllEmployees() {
        EmployeesRepository repo = new EmployeesRepositoryImpl("data/employees_data_for_test.csv");
        List<Employee> allEmployees = repo.getAllEmployees();
        Assert.assertNotNull(allEmployees);
        Assert.assertEquals(4,allEmployees.size());
        Assert.assertNotNull(allEmployees.get(0).getFirstName());
        Assert.assertNotNull(allEmployees.get(0).getLastName());
        Assert.assertTrue(allEmployees.get(0).getSalary()>-1);
    }


}