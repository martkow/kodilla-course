package com.kodilla.spring.forum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@DisplayName("Tests for ForumUser class")
@SpringBootTest
public class ForumUserTestSuite {
    @DisplayName("Test case for getUserName method")
    @Test
    void testGetUserName() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        ForumUser forumUser = context.getBean(ForumUser.class);
        // When
        String result = forumUser.getUserName();
        // Then
        Assertions.assertEquals("John Smith", result);
    }
}
