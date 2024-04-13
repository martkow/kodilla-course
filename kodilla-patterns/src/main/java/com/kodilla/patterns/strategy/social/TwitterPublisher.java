package com.kodilla.patterns.strategy.social;

public final class TwitterPublisher implements SocialPublisher {
    @Override
    public void share(String post) {
        System.out.println("Twitter: " + post);
    }
}
