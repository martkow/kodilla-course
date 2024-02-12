package com.kodilla.testing.forum.statistics;

public class StatisticsController {
    private int numberOfForumUsers;
    private int numberOfForumPosts;
    private int numberOfForumComments;
    private double averageNumberOfPostsPerUser;
    private double averageNumberOfCommentsPerUser;
    private double averageNumberOfCommentsPerPost;

    public int getNumberOfForumUsers() {
        return numberOfForumUsers;
    }

    public int getNumberOfForumPosts() {
        return numberOfForumPosts;
    }

    public int getNumberOfForumComments() {
        return numberOfForumComments;
    }

    public double getAverageNumberOfPostsPerUser() {
        return averageNumberOfPostsPerUser;
    }

    public double getAverageNumberOfCommentsPerUser() {
        return averageNumberOfCommentsPerUser;
    }

    public double getAverageNumberOfCommentsPerPost() {
        return averageNumberOfCommentsPerPost;
    }

    private void setNumberOfForumUsers(int numberOfForumUsers) {
        this.numberOfForumUsers = numberOfForumUsers;
    }

    private void setNumberOfForumPosts(int numberOfForumPosts) {
        this.numberOfForumPosts = numberOfForumPosts;
    }

    private void setNumberOfForumComments(int numberOfForumComments) {
        this.numberOfForumComments = numberOfForumComments;
    }

    private void setAverageNumberOfPostsPerUser(int numberOfForumPosts, int numberOfForumUsers) {
        if (numberOfForumPosts == 0) {
            this.averageNumberOfPostsPerUser = 0;
        } else if (numberOfForumUsers == 0) {
            this.averageNumberOfPostsPerUser = -1;
        } else {
            this.averageNumberOfPostsPerUser = (double)numberOfForumPosts / numberOfForumUsers;
        }
    }

    private void setAverageNumberOfCommentsPerUser(int numberOfForumComments, int numberOfForumUsers) {
        if (numberOfForumComments == 0) {
            this.averageNumberOfCommentsPerUser = 0;
        } else if (numberOfForumUsers == 0) {
            this.averageNumberOfCommentsPerUser = -1;
        } else {
            this.averageNumberOfCommentsPerUser = (double)numberOfForumComments / numberOfForumUsers;
        }
    }

    private void setAverageNumberOfCommentsPerPost(int numberOfForumComments, int numberOfForumPosts) {
        if (numberOfForumComments == 0) {
            this.averageNumberOfCommentsPerPost = 0;
        } else if (numberOfForumPosts == 0) {
            this.averageNumberOfCommentsPerPost = -1;
        } else {
            this.averageNumberOfCommentsPerPost = (double)numberOfForumComments / numberOfForumPosts;
        }
    }

    public void calculateAdvStatistics(Statistics statistics) {
       int numberOfForumUsers = statistics.usersNames().size();
       int numberOfForumPosts = statistics.postsCount();
       int numberOfForumComments = statistics.commentsCount();

       setNumberOfForumUsers(numberOfForumUsers);
       setNumberOfForumPosts(numberOfForumPosts);
       setNumberOfForumComments(numberOfForumComments);
       setAverageNumberOfPostsPerUser(numberOfForumPosts, numberOfForumUsers);
       setAverageNumberOfCommentsPerUser(numberOfForumComments, numberOfForumUsers);
       setAverageNumberOfCommentsPerPost(numberOfForumComments, numberOfForumPosts);
    }

    public String showStatistics() {
        return String.format(
                "--Statistics for Forum --\n" +
                        "Users: %1$d\n" +
                        "Posts: %2$d\n" +
                        "Comments: %3$d\n" +
                        "Average number of posts per user: %4$s\n" +
                        "Average number of comments per user: %5$s\n" +
                        "Average number of comments per post: %6$s\n",
                numberOfForumUsers,
                numberOfForumPosts,
                numberOfForumComments,
                averageNumberOfPostsPerUser == -1 ? "No data" : Double.toString(averageNumberOfCommentsPerUser),
                averageNumberOfCommentsPerUser == -1 ? "No data" : Double.toString(averageNumberOfCommentsPerUser),
                averageNumberOfCommentsPerPost == -1 ? "No data":Double.toString(averageNumberOfCommentsPerPost));
    }

}
