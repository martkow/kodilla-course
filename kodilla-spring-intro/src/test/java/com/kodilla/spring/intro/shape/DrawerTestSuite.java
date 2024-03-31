package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for Drawer class")
public class DrawerTestSuite {
    @DisplayName("Test case for doDrawing method for triangle")
    @Test
    void testCaseForDoDrawingMethodForTriangle() {
        // Given
        Triangle triangle = new Triangle();
        // When
        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();
        // Then
        Assertions.assertEquals("This is a triangle", result);
    }

    @DisplayName("Test case for doDrawing method for circle")
    @Test
    void testCaseForDoDrawingMethodForCircle() {
        // Given
        Circle circle = new Circle();
        // When
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();
        // Then
        Assertions.assertEquals("This is a circle", result);
    }
}
