package com.kodilla.patterns.strategy.social;

public final class Millennials extends User {
    public Millennials(String userName) {
        super(userName);
        super.socialPublisher = new FacebookPublisher();
    }
}
