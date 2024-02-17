package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    private List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "user1", 'M', LocalDate.of(1999, 4, 12), 0));
        userList.add(new ForumUser(2, "user2", 'M', LocalDate.of(1999, 4, 12), 1));
        userList.add(new ForumUser(3, "user3", 'F', LocalDate.of(1999, 4, 12), 0));
        userList.add(new ForumUser(4, "user4", 'F', LocalDate.of(1987, 11, 6), 1));
        userList.add(new ForumUser(5, "user5", 'M', LocalDate.of(2004, 2, 16), 5));
        userList.add(new ForumUser(6, "user6", 'M', LocalDate.of(2020, 4, 12), 10));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }
}
