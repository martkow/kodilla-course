package com.kodilla.testing.forum.tdd.statistics;

import com.kodilla.testing.forum.statistics.Statistics;
import com.kodilla.testing.forum.statistics.StatisticsController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Tests for StatisticsController class")
@ExtendWith(MockitoExtension.class)
public class StatisticsControllerTestSuite {
    @Mock
    private Statistics statisticsMock;
    private StatisticsController statisticsController = new StatisticsController();

    @DisplayName("Test case: posts=0, comments=0, users=0")
    @Test
    void testCaseForCalculateAdvStatisticsForZeroPostsZeroCommentsZeroUsers() {
        // Given
        Mockito.when(statisticsMock.postsCount()).thenReturn(0);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(0);
        Mockito.when(statisticsMock.usersNames()).thenReturn(generateForumUsers(0));
        // When
        statisticsController.calculateAdvStatistics(statisticsMock);
        // Then
        Assertions.assertEquals(0, statisticsController.getNumberOfForumUsers());
        Assertions.assertEquals(0, statisticsController.getNumberOfForumPosts());
        Assertions.assertEquals(0, statisticsController.getNumberOfForumComments());
        Assertions.assertEquals(0, statisticsController.getAverageNumberOfPostsPerUser());
        Assertions.assertEquals(0, statisticsController.getAverageNumberOfCommentsPerUser());
        Assertions.assertEquals(0, statisticsController.getAverageNumberOfCommentsPerPost());
    }

    @DisplayName("Test case: posts=0, comments=0, users=100")
    @Test
    void testCaseForCalculateAdvStatisticsForZeroPostsZeroCommentsHundredUsers() {
        // Given
        Mockito.when(statisticsMock.postsCount()).thenReturn(0);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(0);
        Mockito.when(statisticsMock.usersNames()).thenReturn(generateForumUsers(100));
        // When
        statisticsController.calculateAdvStatistics(statisticsMock);
        // Then
        Assertions.assertEquals(100, statisticsController.getNumberOfForumUsers());
        Assertions.assertEquals(0, statisticsController.getNumberOfForumPosts());
        Assertions.assertEquals(0, statisticsController.getNumberOfForumComments());
        Assertions.assertEquals(0, statisticsController.getAverageNumberOfPostsPerUser());
        Assertions.assertEquals(0, statisticsController.getAverageNumberOfCommentsPerUser());
        Assertions.assertEquals(0, statisticsController.getAverageNumberOfCommentsPerPost());
    }

    @DisplayName("Test case: posts=1000, comments=0, users=0")
    @Test
    void testCaseForCalculateAdvStatisticsForThousandPostsZeroCommentsZeroUsers() {
        // Given
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(0);
        Mockito.when(statisticsMock.usersNames()).thenReturn(generateForumUsers(0));
        // When
        statisticsController.calculateAdvStatistics(statisticsMock);
        // Then
        Assertions.assertEquals(0, statisticsController.getNumberOfForumUsers());
        Assertions.assertEquals(1000, statisticsController.getNumberOfForumPosts());
        Assertions.assertEquals(0, statisticsController.getNumberOfForumComments());
        Assertions.assertEquals(-1, statisticsController.getAverageNumberOfPostsPerUser());
        Assertions.assertEquals(0, statisticsController.getAverageNumberOfCommentsPerUser());
        Assertions.assertEquals(0, statisticsController.getAverageNumberOfCommentsPerPost());
    }

    @DisplayName("Test case: posts=1000, comments=0, users=100")
    @Test
    void testCaseForCalculateAdvStatisticsForThousandPostsZeroCommentsHundredUsers() {
        // Given
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(0);
        Mockito.when(statisticsMock.usersNames()).thenReturn(generateForumUsers(100));
        // When
        statisticsController.calculateAdvStatistics(statisticsMock);
        // Then
        Assertions.assertEquals(100, statisticsController.getNumberOfForumUsers());
        Assertions.assertEquals(1000, statisticsController.getNumberOfForumPosts());
        Assertions.assertEquals(0, statisticsController.getNumberOfForumComments());
        Assertions.assertEquals(10, statisticsController.getAverageNumberOfPostsPerUser());
        Assertions.assertEquals(0, statisticsController.getAverageNumberOfCommentsPerUser());
        Assertions.assertEquals(0, statisticsController.getAverageNumberOfCommentsPerPost());
    }

    @DisplayName("Test case: posts=1000, comments=2000, users=0")
    @Test
    void testCaseForCalculateAdvStatisticsForThousandPostsTwoThousandCommentsZeroUsers() {
        // Given
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(2000);
        Mockito.when(statisticsMock.usersNames()).thenReturn(generateForumUsers(0));
        // When
        statisticsController.calculateAdvStatistics(statisticsMock);
        // Then
        Assertions.assertEquals(0, statisticsController.getNumberOfForumUsers());
        Assertions.assertEquals(1000, statisticsController.getNumberOfForumPosts());
        Assertions.assertEquals(2000, statisticsController.getNumberOfForumComments());
        Assertions.assertEquals(-1, statisticsController.getAverageNumberOfPostsPerUser());
        Assertions.assertEquals(-1, statisticsController.getAverageNumberOfCommentsPerUser());
        Assertions.assertEquals(2, statisticsController.getAverageNumberOfCommentsPerPost());
    }

    @DisplayName("Test case: posts=1000, comments=2000, users=100")
    @Test
    void testCaseForCalculateAdvStatisticsForThousandPostsTwoThousandCommentsHundredUsers() {
        // Given
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(2000);
        Mockito.when(statisticsMock.usersNames()).thenReturn(generateForumUsers(100));
        // When
        statisticsController.calculateAdvStatistics(statisticsMock);
        // Then
        Assertions.assertEquals(100, statisticsController.getNumberOfForumUsers());
        Assertions.assertEquals(1000, statisticsController.getNumberOfForumPosts());
        Assertions.assertEquals(2000, statisticsController.getNumberOfForumComments());
        Assertions.assertEquals(10, statisticsController.getAverageNumberOfPostsPerUser());
        Assertions.assertEquals(20, statisticsController.getAverageNumberOfCommentsPerUser());
        Assertions.assertEquals(2, statisticsController.getAverageNumberOfCommentsPerPost());
    }

    @DisplayName("Test case for showStatistics method: posts=1000, comments=2000, users=0")
    @Test
    void testCaseForShowStatisticsMethodForThousandPostsTwoThousandCommentsZeroUsers() {
        // Given
        Mockito.when(statisticsMock.postsCount()).thenReturn(1000);
        Mockito.when(statisticsMock.commentsCount()).thenReturn(2000);
        Mockito.when(statisticsMock.usersNames()).thenReturn(generateForumUsers(0));
        statisticsController.calculateAdvStatistics(statisticsMock);
        // When
        String result = statisticsController.showStatistics();
        // Then
        Assertions.assertEquals("""
                        --Statistics for Forum --
                        Users: 0
                        Posts: 1000
                        Comments: 2000
                        Average number of posts per user: No data
                        Average number of comments per user: No data
                        Average number of comments per post: 2.0
                        """
                , result);
    }

    private List<String> generateForumUsers(int numberOfForumUsers) {
        List<String> forumUsers = new ArrayList<>();

        for (int i = 0; i < numberOfForumUsers; i++) {
            forumUsers.add("U" + i);
        }

        return forumUsers;
    }
}
