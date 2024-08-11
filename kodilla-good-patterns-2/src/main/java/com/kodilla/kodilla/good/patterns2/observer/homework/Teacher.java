package com.kodilla.kodilla.good.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Teacher implements Observer {
    private final String username;
    private final List<Student> students;
    private int updatedCount;

    public Teacher(String username) {
        this.username = username;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int gradeHomework(String s) {
        return new Random().nextInt(1, 7);
    }

    public int getUpdatedCount() {
        return updatedCount;
    }

    @Override
    public void update(Student student) {
        System.out.println("Student: " + student.getUsername() + "\n" +
                "New homework to grade: " + student.getHomeworks().peekFirst());
        updatedCount++;
    }
}
