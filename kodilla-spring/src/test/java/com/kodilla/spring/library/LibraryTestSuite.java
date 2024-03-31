package com.kodilla.spring.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Tests for Library class")
@SpringBootTest
public class LibraryTestSuite {
    @Autowired
    private Library library;

    @DisplayName("Test case for loadFromDb method")
    @Test
    void testLoadFromDb() {
        //Given
        //When
        library.loadFromDb();
        //Then
        //do nothing
    }

    @DisplayName("Test case for saveToDb method")
    @Test
    void testSaveToDb() {
        //Given
        //When
        library.saveToDb();
        //Then
        //do nothing
    }
}
