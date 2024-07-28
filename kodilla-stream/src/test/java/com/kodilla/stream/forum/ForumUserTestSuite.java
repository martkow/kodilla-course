package com.kodilla.stream.forum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@DisplayName("Test suite for ForumUser class")
@ExtendWith(MockitoExtension.class)
public class ForumUserTestSuite {
    @DisplayName("Test case for getLocationsOfFriends method for empty set of friends")
    @Test
    void testCaseForGetLocationsOfFriendsMethodForEmptySet() {
        // Given
        ForumUser forumUser = new ForumUser("bubu", "Bubuslaw Bubuslawski", "Gdansk");
        // When
        Set<String> result = forumUser.getLocationsOfFriends();
        // Then
        Assertions.assertEquals(new HashSet<>(), result);
    }

    @DisplayName("Test case for getLocationsOfFriends method for nonempty set of friends")
    @Test
    void testCaseForGetLocationsOfFriendsMethodForNonemptySet() {
        // Given
        ForumUser forumUser = new ForumUser("bubu", "Bubuslaw Bubuslawski", "Gdansk");
        forumUser.addFriend(new ForumUser("friend1", "Friend1", "Sopot"));
        // When
        Set<String> result = forumUser.getLocationsOfFriends();
        // Then
        Assertions.assertEquals(new HashSet<>(List.of("Sopot")), result);
    }

    @DisplayName("Test case for addFriend method")
    @Test
    void testCaseForAddFriendMethod() {
        // Given
        ForumUser forumUser = new ForumUser("bubu", "Bubuslaw Bubuslawski", "Gdansk");
        // When
        forumUser.addFriend(new ForumUser("friend1", "Friend1", "Sopot"));
        // Then
        Assertions.assertEquals(1, forumUser.getFriends().size());
        Assertions.assertTrue(forumUser.getFriends().contains(new ForumUser("friend1", "Friend1", "Sopot")));
    }

    @DisplayName("Test case for getLocationsOfFriendsOfFriends method")
    @Test
    void testCaseForGetLocationsOfFriendsOfFriendsMethod() {
        // Given
        ForumUser forumUser1 = new ForumUser("bubu1", "Bubuslaw Bubuslawski1", "Torun");
        ForumUser forumUser2 = new ForumUser("bubu2", "Bubuslaw Bubuslawski2", "Sopot");
        ForumUser forumUser3 = new ForumUser("bubu3", "Bubuslaw Bubuslawski3", "Gdynia");
        ForumUser forumUser4 = new ForumUser("bubu4", "Bubuslaw Bubuslawski4", "Gdansk");
        forumUser1.addFriend(forumUser2);
        forumUser1.addFriend(forumUser3);
        forumUser2.addFriend(forumUser1);
        forumUser2.addFriend(forumUser4);
        forumUser3.addFriend(forumUser1);
        // When
        Set<String> result = forumUser1.getLocationsOfFriendsOfFriends();
        // Then
        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.contains("Gdansk"));

        int[] t = new int[0];

        List<String> l = new ArrayList<>();
        l.stream().collect(Collectors.toSet());
    }
}
