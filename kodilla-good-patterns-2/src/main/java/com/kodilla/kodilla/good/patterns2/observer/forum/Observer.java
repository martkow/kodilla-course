package com.kodilla.kodilla.good.patterns2.observer.forum;

/**
 * Observer:
 * The observer is an interface or abstract class that defines the method update(), which is called by the subject when the state changes.
 * Concrete observers implement this interface and define how they should respond when they are notified of a change.<br><br>
 * Subject (Observable):
 * The subject is the object that holds the state and notifies observers when the state changes.
 * It maintains a list of observers that are interested in being notified of changes.<br><br>
 * ConcreteSubject:
 * A specific implementation of the subject that holds the actual state.
 * When the state changes, it notifies all registered observers.<br><br>
 * ConcreteObserver:
 * A specific implementation of an observer that reacts to changes in the subject.
 * The update() method in this class is where the observer's response to the change is defined.
 */
public interface Observer {
    void update(ForumTopic forumTopic);
}
