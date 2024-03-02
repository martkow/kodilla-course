package com.kodilla.exception.nullpointer;

import java.util.Optional;

public class NullPointerExceptionRunner {
    public static void main(String[] args) {
        MessageSender messageSender = new MessageSender();
        try {
            messageSender.sendMessageTo(null, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Message was not send: " + e.getMessage());
        }

        // Using Optional
        User user = null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        String name = optionalUser.orElse(new User("x")).getName();
        System.out.println(name);
    }
}
