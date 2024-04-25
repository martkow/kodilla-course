package com.kodilla.exception.nullpointer;

public class MessageNotSentException extends Exception {
    public MessageNotSentException(String message) {
        super(message);
    }
}
