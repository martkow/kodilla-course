package com.kodilla.kodilla.good.patterns2.observer.forum;

import java.util.ArrayList;
import java.util.List;

public class ForumTopic implements Observable {
    private final List<String> messages;
    private final String name;
    private final List<Observer> observers; // A list of observers who have subscribed to receive notifications about changes (new posts).

    public ForumTopic(String name) {
        messages = new ArrayList<>();
        this.name = name;
        observers = new ArrayList<>();
    }

    public void addPost(String post) {
        messages.add(post);
        notifyObservers();
    }

    /**
     * Methods for handling subscription to changes and unsubscribing have also been implemented. Additionally, the notifyObservers() method has been implemented, which calls the update(ForumTopic forumTopic) method on each of the observers.
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public String getName() {
        return name;
    }

    public List<String> getMessages() {
        return messages;
    }
}