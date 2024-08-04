package com.kodilla.kodilla.good.patterns2.aop.calculator;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * To enable support for aspects in a Spring Boot application, you need to use the @EnableAspectJAutoProxy annotation. This annotation tells Spring to look for and process aspect-oriented programming (AOP) annotations in the application.<br><br>
 * The @EnableAspectJAutoProxy annotation should be placed in a configuration class that is within the Spring scanning range. This ensures that the annotation is detected and aspect support is enabled.
 * Typically, this annotation can be added to:
 * <ul>
 *  <li>
 *      a configuration class - enable aspect support for the entire app
 *  </li>
 *  <li>
 *      the main application class - enable aspect support for the entire app
 *  </li>
 * </ul>
 */
@EnableAspectJAutoProxy //  Enable aspect support for this specific class. The class cannot be 'final'.
@Component
public class Calculator {
    public double add(double x, double y) {
        return x + y;
    }

    public double sub(double x, double y) {
        return x - y;
    }

    public double mul(double x, double y) {
        return x * y;
    }

    public double div(double x, double y) {
        if (y == 0) {
            throw new ArithmeticException("Divide by zero!");

        }

        return x / y;
    }

    public BigDecimal factorial(int n) {
        if (n < 0) {
            throw new ArithmeticException("Factorial argument is negative.");
        }
        if (n == 0 || n == 1) {
            return BigDecimal.ONE;
        }

        return new BigDecimal(n).multiply(factorial(n - 1));
    }
}