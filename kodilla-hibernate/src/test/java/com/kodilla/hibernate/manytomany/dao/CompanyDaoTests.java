package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.domain.Company;
import com.kodilla.hibernate.manytomany.domain.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@DisplayName("Tests for CompanyDao interface - Data Object Access layer -> Repository controller")
@SpringBootTest
public class CompanyDaoTests {
    @Autowired
    private CompanyDao companyDao;

    @DisplayName("Test case for save method with saving to related tables: M:N")
    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        //Then
        Assertions.assertNotEquals(0, softwareMachineId);
        Assertions.assertNotEquals(0, dataMaestersId);
        Assertions.assertNotEquals(0, greyMatterId);
        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @DisplayName("Test case for retrieveCompanyByFirstThreeCharactersOfCompanyName method")
    @Test
    void testRetrieveCompanyByFirstThreeCharactersOfCompanyName() {
        // Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Som Maesters");
        Company greyMatter = new Company("Software Matter");

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        // When
        List<Company> result = companyDao.retrieveCompanyByFirstThreeCharactersOfCompanyName("sof");
        // Then
        Assertions.assertEquals(2, result.size());
        // Cleanup
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
