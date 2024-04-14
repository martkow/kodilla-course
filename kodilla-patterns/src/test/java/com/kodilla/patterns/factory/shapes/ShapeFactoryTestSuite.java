package com.kodilla.patterns.factory.shapes;

import com.kodilla.patterns.factory.shapes.Shape;
import com.kodilla.patterns.factory.shapes.ShapeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for ShapeFactory class")
public class ShapeFactoryTestSuite {
    @DisplayName("Test case for makeShape method for CIRCLE")
    @Test
    void testCaseForMakeShapeMethodForCircle() {
        // Given
        ShapeFactory shapeFactory = new ShapeFactory();
        // When
        Shape result = shapeFactory.makeShape(ShapeFactory.CIRCLE);
        // Then
        Assertions.assertEquals("The rounded circle", result.getName());
        Assertions.assertEquals(result.getArea(), Math.PI * 4.50 * 4.50, 0);
        System.out.println(result.getArea() + " -> " + Math.PI * 4.50 * 4.50);
    }

    @DisplayName("Test case for makeShape method for SQUARE")
    @Test
    void testCaseForMakeShapeMethodForSquare() {
        // Given
        ShapeFactory shapeFactory = new ShapeFactory();
        // When
        Shape result = shapeFactory.makeShape(ShapeFactory.SQUARE);
        // Then
        Assertions.assertEquals("The angular square", result.getName());
        Assertions.assertEquals(result.getArea(), 49, 0);
    }

    @DisplayName("Test case for makeShape method for RECTANGLE")
    @Test
    void testCaseForMakeShapeMethodForRectangle() {
        // Given
        ShapeFactory shapeFactory = new ShapeFactory();
        // When
        Shape result = shapeFactory.makeShape(ShapeFactory.RECTANGLE);
        // Then
        Assertions.assertEquals("The long rectangle", result.getName());
        Assertions.assertEquals(result.getArea(), 37.5);
    }
}
