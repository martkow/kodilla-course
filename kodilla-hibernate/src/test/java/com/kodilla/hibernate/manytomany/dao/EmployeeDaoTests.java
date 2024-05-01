package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@DisplayName("Tests for EmployeeDao interface - Data Object Access layer -> Repository controller")
@SpringBootTest
public class EmployeeDaoTests {
    @Autowired
    private EmployeeDao employeeDao;

    @DisplayName("Test case for retrieveEmployeeByLastname method")
    @Test
    void testRetrieveEmployeeByLastname() {
        // Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaSmith = new Employee("Linda", "Smith");

        employeeDao.save(johnSmith);
        int johnSmithId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieClarcksonId = stephanieClarckson.getId();
        employeeDao.save(lindaSmith);
        int lindaSmithId = lindaSmith.getId();
        // When
        List<Employee> result = employeeDao.retrieveEmployeeByLastname("Smith");
        // Then
        Assertions.assertEquals(2, result.size());
        // Cleanup
        try {
            employeeDao.deleteById(johnSmithId);
            employeeDao.deleteById(stephanieClarcksonId);
            employeeDao.deleteById(lindaSmithId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
