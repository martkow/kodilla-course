package com.kodilla.kodilla.good.patterns2.observer.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for Student class")
public class StudentTests {
    @Test
    void shouldNotifyTeacher() {
        // Given
        Teacher bubuslawski = new Teacher("Bubuslawski");

        Student s1 = new Student("Student 1", bubuslawski);
        bubuslawski.addStudent(s1);
        Student s2 = new Student("Student 2", bubuslawski);
        bubuslawski.addStudent(s2);

        s1.addHomework("s1: Homework 1");
        s1.addHomework("s1: Homework 2");
        s2.addHomework("s2: Homework 1");
        // When
        // Then
        Assertions.assertEquals(3, bubuslawski.getUpdatedCount());
    }
}
