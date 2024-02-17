package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {
    private final int userId;
    private String username;
    private final char sex;
    private final LocalDate birthdate;
    private int publishedPostsNumber;

    public ForumUser(int userId, String username, char sex, LocalDate birthdate, int publishedPostsNumber) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthdate = birthdate;
        this.publishedPostsNumber = publishedPostsNumber;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public int getPublishedPostsNumber() {
        return publishedPostsNumber;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthdate=" + birthdate +
                ", publishedPostsNumber=" + publishedPostsNumber +
                '}';
    }
}
