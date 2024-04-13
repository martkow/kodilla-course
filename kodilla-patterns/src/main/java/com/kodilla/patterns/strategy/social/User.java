package com.kodilla.patterns.strategy.social;

public sealed class User permits Millennials, YGeneration, ZGeneration {
    private String userName;
    protected SocialPublisher socialPublisher;

    public User(String userName) {
        this.userName = userName;
    }

    public void sharePost(String post) {
        socialPublisher.share(post);
    }

    public void setSocialPublisher(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }
}
