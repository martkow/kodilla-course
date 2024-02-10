package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("Tests for ForumUser class - TDD approach \uD83D\uDC3A")
public class ForumUserTestSuite {
    private static int testCounter;

    @BeforeAll
    static void testsStartInfo() {
        System.out.println("Tests for ForumUser class");
    }

    @AfterAll
    static void testsEndInfo() {
        System.out.println("All tests passed");
    }

    @BeforeEach
    void testCaseStartInfo() {
        testCounter++;
        System.out.println("Preparing to execute test case #" + testCounter);
    }

    @AfterEach
    void testCaseEndInfo() {
        System.out.println("Test case #" + testCounter + " passed");
    }

    @DisplayName("Test case for getName method")
    @Test
    void testCaseGetNameMethod() {
        // Given
        ForumUser forumUser = new ForumUser("bubu", "Bubuslaw");
        // When
        String result = forumUser.getName();
        // Then
        Assertions.assertEquals("bubu", result);
    }

    @DisplayName("Test case for getRealName method")
    @Test
    void testCaseGetRealNameMethod() {
        // Given
        ForumUser forumUser = new ForumUser("bubu", "Bubuslaw");
        // When
        String result = forumUser.getRealName();
        // Then
        Assertions.assertEquals("Bubuslaw", result);
    }

    @Nested
    @DisplayName("Tests for posts")
    class PostsTestSuite {
        @DisplayName("Test case for addPost method")
        @Test
        void testCaseAddPostMethod() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            // When
            forumUser.addPost("bubu", "I am the cutest, blink, blink");
            // Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        @DisplayName("Test case for getPostsQuantity method")
        @Test
        void testCaseGetPostsQuantityMethod() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            forumUser.addPost("bubu", "I am the cutest, blink, blink");
            forumUser.addPost("bubu", "Hello!!!");
            // When
            int result = forumUser.getPostsQuantity();
            // Then
            Assertions.assertEquals(2, result);
        }

        @DisplayName("Test case for getPost method for valid post number")
        @Test
        void testCaseGetPostMethodForValidPostNumber() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            ForumPost forumPost = new ForumPost("I am the cutest, blink, blink", "bubu");
            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());
            // When
            ForumPost result = forumUser.getPost(0);
            // Then
            Assertions.assertEquals(forumPost, result);
        }

        @DisplayName("Test case for getPost method for invalid post number")
        @Test
        void testCaseGetPostMethodForInvalidPostNumber() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            // When
            ForumPost result = forumUser.getPost(10);
            // Then
            Assertions.assertNull(result);
        }

        @DisplayName("Test case for removePost method for existing post")
        @Test
        void testCaseRemovePostMethodForExistingPost() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            ForumPost forumPost = new ForumPost("I am the cutest, blink, blink", "bubu");
            forumUser.addPost(forumPost.getAuthor(), forumPost.getPostBody());
            // When
            boolean result = forumUser.removePost(forumPost);
            // Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }

        @DisplayName("Test case for removePost method for nonexistent post")
        @Test
        void testCaseRemovePostMethodForNonexistentPost() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            // When
            boolean result = forumUser.removePost(new ForumPost("I am the cutest, blink, blink", "bubu"));
            // Then
            Assertions.assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Tests for comments")
    class CommentsTestSuite {
        @DisplayName("Test case for addComment method")
        @Test
        void testCaseAddCommentMethod() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            ForumPost forumPost = new ForumPost("I am the cutest, blink, blink", "bubu");
            // When
            forumUser.addComment(forumPost, "bubu", "Sure :)");
            // Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        @DisplayName("Test case for getCommentsQuantity")
        @Test
        void testCaseGetCommentsQuantityMethod() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            ForumPost forumPost = new ForumPost("I am the cutest, blink, blink", "bubu");
            forumUser.addComment(forumPost, "bubu", "Yeaya...");
            forumUser.addComment(forumPost, "bubu", "Yes, you are!");
            // When
            int result = forumUser.getCommentsQuantity();
            // Then
            Assertions.assertEquals(2, result);
        }

        @DisplayName("Test case for getComment method for valid comment number")
        @Test
        void testCaseGetCommentMethodForValidCommentNumber() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            ForumPost forumPost = new ForumPost("I am the cutest, blink, blink", "bubu");
            ForumComment forumComment = new ForumComment(forumPost, "Yeaya...", "bubu");
            forumUser.addComment(forumPost, forumComment.getAuthor(), forumComment.getCommentBody());
            // When
            ForumComment result = forumUser.getComment(0);
            // Then
            Assertions.assertEquals(forumComment, result);
        }

        @DisplayName("Test case for getComment method fo invalid comment number")
        @Test
        void testCaseGetCommentMethodForInvalidCommentNumber() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            // When
            ForumComment result = forumUser.getComment(0);
            // Then
            Assertions.assertNull(result);
        }

        @DisplayName("Test case for removeComment method for existing comment")
        @Test
        void testCaseRemoveCommentMethodForExitingComment() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            ForumPost forumPost = new ForumPost("I am the cutest, blink, blink", "bubu");
            ForumComment forumComment = new ForumComment(forumPost, "Yeaya...", "bubu");
            forumUser.addComment(forumPost, forumPost.getAuthor(), forumComment.getCommentBody());
            // When
            boolean result = forumUser.removeComment(new ForumComment(forumPost, "Yeaya...", "bubu"));
            // Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }

        @DisplayName("Test case for removeComment method for nonexistent comment")
        @Test
        void testCaseRemoveCommentMethodForNonexistentComment() {
            // Given
            ForumUser forumUser = new ForumUser("bubu", "Bubslaw");
            ForumPost forumPost = new ForumPost("I am the cutest, blink, blink", "bubu");
            // When
            boolean result = forumUser.removeComment(new ForumComment(forumPost, "Yeaya...", "bubu"));
            // Then
            Assertions.assertFalse(result);
        }
    }
}
