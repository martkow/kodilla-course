package com.kodilla.patterns.strategy.social;

public final class FacebookPublisher implements SocialPublisher {
    @Override
    public void share(String post) {
        System.out.println("Facebook: " + post);
    }
}
