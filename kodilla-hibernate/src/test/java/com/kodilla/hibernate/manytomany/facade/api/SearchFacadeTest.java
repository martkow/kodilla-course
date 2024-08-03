package com.kodilla.hibernate.manytomany.facade.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Tests for SearchFacade class.")
@SpringBootTest
public class SearchFacadeTest {
    @Autowired
    private SearchFacade searchFacade;

    @Test
    void shouldReturnCompany() {
        // Given
        // When
        // Then
        try {
            searchFacade.searchCompany("Bub").stream().forEach(System.out::println);
        } catch (SearchCompanyException sce) {
            //
        }
    }

    @Test
    void shouldReturnEmployee() {
        // Given
        // When
        // Then
        try {
            searchFacade.searchEmployee("Marc").stream().forEach(System.out::println);
        } catch (SearchEmployeeException sce) {
            //
        }
    }
}
