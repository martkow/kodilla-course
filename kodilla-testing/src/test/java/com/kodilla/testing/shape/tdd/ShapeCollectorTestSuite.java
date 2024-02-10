package com.kodilla.testing.shape.tdd;

import com.kodilla.testing.shape.Shape;
import com.kodilla.testing.shape.ShapeCollector;
import com.kodilla.testing.shape.Square;
import com.kodilla.testing.shape.Triangle;
import org.junit.jupiter.api.*;

@DisplayName("Tests for ShapeCollector class")
public class ShapeCollectorTestSuite {
    private static int testCount;

    @BeforeAll
    static void testsStartInfo() {
        System.out.println("Tests for ShapeCollector class");
    }

    @AfterAll
    static void testsEndInfo() {
        System.out.println("All tests passed");
    }

    @BeforeEach
    void testCaseStartInfo() {
        testCount++;
        System.out.println("Test case #" + testCount);
    }

    @AfterEach
    void testCaseEndInfo() {
        System.out.println("Test case #" + testCount + " passed");
    }

    @Nested
    @DisplayName("Tests for shapes management")
    class ShapesManagementTestSuite {
        @DisplayName("Test case for addShape method")
        @Test
        void testCaseAddShapeMethod() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(10.5);
            // When
            shapeCollector.addShape(square);
            // Then
            Assertions.assertEquals(1, shapeCollector.getShapes().size());
        }

        @DisplayName("Test case for removeShape method for exiting shape")
        @Test
        void testCaseRemoveShapeMethodForExistingShape() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(10.5);
            Shape triangle = new Triangle(2, 12.5);
            shapeCollector.addShape(square);
            shapeCollector.addShape(square);
            shapeCollector.addShape(triangle);
            shapeCollector.addShape(square);
            // When
            boolean result = shapeCollector.removeShape(square);
            // Then
            Assertions.assertTrue(result);
            Assertions.assertFalse(shapeCollector.getShapes().contains(square));
        }

        @DisplayName("Test case for removeShape method for nonexistent shape")
        @Test
        void testCaseRemoveShapeMethodForNonexistentShape() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            // When
            boolean result = shapeCollector.removeShape(new Triangle(2, 12.5));
            // Then
            Assertions.assertFalse(result);
        }


        @DisplayName("Test case for getShape method for valid shape number")
        @Test
        void testCaseGetShapeMethodForValidShapeNumber() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape triangle = new Triangle(2, 12.5);
            shapeCollector.addShape(triangle);
            // When
           Shape result = shapeCollector.getShape(0);
            // Then
            Assertions.assertEquals(triangle, result);
        }

        @DisplayName("Test case for getShape method for invalid shape number")
        @Test
        void testCaseGetShapeMethodForInvalidShapeNumber() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            // When
            Shape result = shapeCollector.getShape(0);
            // Then
            Assertions.assertNull(result);
        }
    }

    @Nested
    @DisplayName("Tests for printing shapes")
    class PrintingShapesTestSuite {

        @DisplayName("Test case for showShapes method for nonempty list")
        @Test
        void testCaseShowShapesMethodForNonemptyList() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape square = new Square(10.5);
            Shape triangle = new Triangle(2, 12.5);
            shapeCollector.addShape(square);
            shapeCollector.addShape(triangle);
            // When
            String result = shapeCollector.showShapes();
            // Then
            Assertions.assertEquals("[Square, Triangle]", result);
        }

        @DisplayName("Test case for showShapes method for empty list")
        @Test
        void testCaseShowShapesMethodForEmptyList() {
            // Given
            ShapeCollector shapeCollector = new ShapeCollector();
            // When
            String result = shapeCollector.showShapes();
            // Then
            Assertions.assertEquals("[]", result);
        }
    }
}
