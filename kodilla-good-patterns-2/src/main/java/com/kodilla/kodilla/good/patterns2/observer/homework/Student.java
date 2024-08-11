package com.kodilla.kodilla.good.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Student implements Observable {
    private final String username;
    private final Teacher teacher;
    private final Deque<String> homeworks;
    private final Map<String, Integer> grades;

    public Student(String username, Teacher teacher) {
        this.username = username;
        this.teacher = teacher;
        this.homeworks = new ArrayDeque<>();
        this.grades = new HashMap<>();
    }

    public void addHomework(String homework) {
        homeworks.addLast(homework);
        notifyObserver();
    }

    public void handleHomework() {
        String homework = homeworks.pollFirst();
        grades.put(homework, teacher.gradeHomework(homework));
    }

    public String getUsername() {
        return username;
    }

    public Deque<String> getHomeworks() {
        return homeworks;
    }

    @Override
    public void notifyObserver() {
        teacher.update(this);
    }
}
