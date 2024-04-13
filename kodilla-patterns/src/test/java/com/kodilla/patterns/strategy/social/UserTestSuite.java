package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for User class")
public class UserTestSuite {
    @DisplayName("Test case for sharePost method for millennial user")
    @Test
    void testCaseForSharePostMethodForMillennialUser() {
        // Given
        Millennials millennials = new Millennials("Millennial user");
        // When & Then
        millennials.sharePost("My post");
    }

    @DisplayName("Test case for sharePost method for generation Y user")
    @Test
    void testCaseForSharePostMethodForYGenerationUser() {
        // Given
        YGeneration yGeneration = new YGeneration("YGeneration user");
        // When & Then
        yGeneration.sharePost("My post");
    }

    @DisplayName("Test case for sharePost method for generation Z user")
    @Test
    void testCaseForSharePostMethodForZGenerationUser() {
        // Given
        ZGeneration zGeneration = new ZGeneration("ZGeneration user");
        // When & Then
        zGeneration.sharePost("My post");
    }

    @DisplayName("Test case for setSocialPublisher method for generation Z user")
    @Test
    void testCaseForSetSocialPublisherMethodForZGenerationUser() {
        // Given
        ZGeneration zGeneration = new ZGeneration("ZGeneration user");
        // When
        zGeneration.setSocialPublisher(new SnapchatPublisher());
        // Then
       zGeneration.sharePost("My post");
    }
}
