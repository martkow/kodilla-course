package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Calculator {
    @Autowired // Field injection is not recommended
    private Display display;

    public double add(double a, double b) {
        double value = a + b;
        display.displayValue(value);
        return value;
    }

    public double sub(double a, double b) {
        double value = a - b;
        display.displayValue(value);
        return value;
    }

    public double mul(double a, double b) {
        double value = a * b;
        display.displayValue(value);
        return value;
    }

    public double div(double a, double b) throws IllegalArgumentException {
        if (b == 0) {
            throw new IllegalArgumentException();
        }
        double value = a / b;
        display.displayValue(value);
        return value;
    }
}
