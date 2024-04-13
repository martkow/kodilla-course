package com.kodilla.patterns.strategy.social;

public final class SnapchatPublisher implements SocialPublisher {
    @Override
    public void share(String post) {
        System.out.println("Snapchat: " + post);
    }
}
