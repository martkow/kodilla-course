package com.kodilla.spring.reader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@DisplayName("Tests for Reader class")
@SpringBootTest
public class ReaderTestSuite {
    @DisplayName("Test case for read method")
    @Test
    void testRead() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        Reader reader = context.getBean(Reader.class);
        //When & Then
        reader.read();
    }

    @DisplayName("Test case for @conditional")
    @Test
    void testCaseForConditional() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        Reader reader = context.getBean(Reader.class);
        // When
        boolean result = context.containsBean("book2");
        // Then
        System.out.println(result);
        System.out.println("===== Beans list: ==== >>");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        System.out.println("<< ===== Beans list ====");
    }
}
