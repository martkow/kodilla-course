package com.kodilla.stream.forum;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ForumUser {
    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(String username, String realName, String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ForumUser forumUser = (ForumUser) o;
        return Objects.equals(username, forumUser.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public void addFriend(ForumUser forumUser) {
        friends.add(forumUser);
    }

    public boolean removeFriend(ForumUser forumUser) {
        return friends.remove(forumUser);
    }

    public Set<String> getLocationsOfFriends() {
        return friends.stream()
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }

    public Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream()
                .flatMap(u -> u.friends.stream())
                .filter(u -> u != this)
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }
}
