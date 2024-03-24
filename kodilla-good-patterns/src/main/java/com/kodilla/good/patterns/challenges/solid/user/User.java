package com.kodilla.good.patterns.challenges.solid.user;

public class User {
    private static long counter;
    private long userId;
    private String userName;
    private String userEmail;

    public User(String userName, String userEmail) {
        this.userId = ++counter;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
