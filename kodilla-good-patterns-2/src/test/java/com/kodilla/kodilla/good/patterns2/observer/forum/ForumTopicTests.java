package com.kodilla.kodilla.good.patterns2.observer.forum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for ForumTopic class")
public class ForumTopicTests {
    @Test
    void shouldNotifyForumUser() {
        // Given
        ForumTopic javaHelpForum = new JavaHelpForumTopic();
        ForumTopic javaToolsForum = new JavaToolsForumTopic();

        ForumUser johnSmith = new ForumUser("John Smith");
        ForumUser ivoneEscobar= new ForumUser("Ivone Escobar");
        ForumUser jessiePinkman = new ForumUser("Jessie Pinkman");

        javaHelpForum.registerObserver(johnSmith);
        javaHelpForum.registerObserver(jessiePinkman);

        javaToolsForum.registerObserver(ivoneEscobar);
        javaToolsForum.registerObserver(jessiePinkman);
        // When
        javaHelpForum.addPost("Hi everyoe! Could you help me with for loop?");
        javaHelpForum.addPost("Better try to use while loop in this case.");
        javaHelpForum.addPost("Why while? Is it better?");

        javaToolsForum.addPost("Help pls, my MySQL db doesn't want to work :(");
        javaToolsForum.addPost("When I try to log in I got 'bad credentials' message");
        // Then
        Assertions.assertEquals(3, johnSmith.getUpdateCount());
        Assertions.assertEquals(2, ivoneEscobar.getUpdateCount());
        Assertions.assertEquals(5, jessiePinkman.getUpdateCount());
    }
}
