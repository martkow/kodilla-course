package com.kodilla.kodilla.good.patterns2.observer.forum;

public interface Observable {
    void registerObserver(Observer observer); // Allows any observer to "subscribe" to changes in the object implementing the Observable interface.
    void notifyObservers(); // Allows an observer to unsubscribe from the list of subscribers.
    void removeObserver(Observer observer); // Sends notifications to all observers that a change has occurred in the object (a new post has appeared).
}
