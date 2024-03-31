package com.kodilla.spring.library;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@DisplayName("Tests for LibraryV2 class")
@SpringBootTest
public class LibraryV2TestSuite {
    @Autowired
    private LibraryV2 libraryV2;

    @DisplayName("Test case for loadFromDb method")
    @Test
    void testLoadFromDb() {
        //Given
        //When
        libraryV2.loadFromDb();
        //Then
        //do nothing
    }

    @DisplayName("Test case for saveToDb method")
    @Test
    void testSaveToDb() {
        //Given
        //When
        libraryV2.saveToDb();
        //Then
        //do nothing
    }

    @Test
    void testContextCreatedByConfigClass() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext(LibraryV2Config.class);
        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }

    @Test
    void testContextCreatedByAnnotationAndConfigClass() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        //When & Then
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}
