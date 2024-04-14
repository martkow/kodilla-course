package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

@DisplayName("Tests for TaskFactory class")
public class TaskFactoryTestSuite {
    @DisplayName("Test case for createTask method for driving task")
    @Test
    void testCaseForCreateTaskMethodForDrivingTask() {
        // Given
        // When
        Task result = TaskFactory.createTask(TaskFactory.DRIVING_TASK);
        // Then
        Assertions.assertEquals("drive", result.getTaskName());
        Assertions.assertFalse(result.isTaskExecuted());
    }

    @DisplayName("Test case for createTask method for painting task")
    @Test
    void testCaseForCreateTaskMethodForPaintingTask() {
        // Given
        // When
        Task result = TaskFactory.createTask(TaskFactory.PAINTING_TASK);
        // Then
        Assertions.assertEquals("paint", result.getTaskName());
        Assertions.assertFalse(result.isTaskExecuted());
    }

    @DisplayName("Test case for createTask method for shopping task")
    @Test
    void testCaseForCreateTaskMethodForShoppingTask() {
        // Given
        // When
        Task result = TaskFactory.createTask(TaskFactory.SHOPPING_TASK);
        // Then
        Assertions.assertEquals("buy", result.getTaskName());
        Assertions.assertFalse(result.isTaskExecuted());
    }

    @DisplayName("Test case for createTask method for not implemented task")
    @Test
    void testCaseForCreateTaskMethodForNotImplementedTask() {
        // Given
        // When
        Executable result = () -> TaskFactory.createTask("Unknown task");
        // Then
        Assertions.assertThrows(IllegalStateException.class, result);
    }
}
