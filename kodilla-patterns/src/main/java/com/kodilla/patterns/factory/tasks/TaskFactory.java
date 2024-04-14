package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    static final String DRIVING_TASK = "DRIVING_TASK";
    static final String PAINTING_TASK = "PAINTING_TASK";
    static final String SHOPPING_TASK = "SHOPPING_TASK";

    public static Task createTask(String taskClass) {
        return switch (taskClass) {
            case DRIVING_TASK -> new DrivingTask("drive", "Gdańsk", "plane");
            case PAINTING_TASK -> new PaintingTask("paint", "bench", "grey");
            case SHOPPING_TASK -> new ShoppingTask("buy", "apples", 10);
            default -> throw new IllegalStateException("Unexpected value: " + taskClass);
        };
    }
}
