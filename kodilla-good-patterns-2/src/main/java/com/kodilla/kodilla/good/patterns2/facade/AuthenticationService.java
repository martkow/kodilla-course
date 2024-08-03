package com.kodilla.kodilla.good.patterns2.facade;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthenticationService {
    public boolean isAuthenticated(Long userId) {
        Random random = new Random();
        return random.nextBoolean();
    }
}
