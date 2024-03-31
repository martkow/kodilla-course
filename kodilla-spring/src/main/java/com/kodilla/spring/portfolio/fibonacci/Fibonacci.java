package com.kodilla.spring.portfolio.fibonacci;

import org.springframework.stereotype.Component;

@Component
public class Fibonacci {
    private static final int ZERO_FIBONACCI_NUMBER = 0;
    private static final int ONE_FIBONACCI_NUMBER = 1;

    public int calculateNFibonacciNumber(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return ZERO_FIBONACCI_NUMBER;
        } else if (n == 1) {
            return ONE_FIBONACCI_NUMBER;
        }
        return calculateNFibonacciNumber(n - 2) + calculateNFibonacciNumber(n - 1);
    }

    public int calculateNFibonacciNumberNoRecursion(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int fib0 = ZERO_FIBONACCI_NUMBER;
        int fib1 = ONE_FIBONACCI_NUMBER;
        for (int i = 1; i <= n; i++) {
            int temp = fib0 + fib1;
            fib0 = fib1;
            fib1 = temp;
        }
        return fib0;
    }
}
