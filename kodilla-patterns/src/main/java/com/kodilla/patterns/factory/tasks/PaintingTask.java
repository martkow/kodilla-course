package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task {
    private String taskName;
    private String whatToPaint;
    private String color;
    private boolean executed;

    public PaintingTask(String taskName, String whatToPaint, String color) {
        this.taskName = taskName;
        this.whatToPaint = whatToPaint;
        this.color = color;
    }

    @Override
    public void executeTask() {
        if (executed) {
            System.out.println("Task is already executed");
        } else {
            System.out.println("Executing task: " + taskName + " " + whatToPaint + " " + color);
            executed = true;
        }
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        return executed;
    }
}
