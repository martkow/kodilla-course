package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to Module 7 - Stream");

        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("Bubu");
        processor.execute(codeToExecute);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(1.5, 2.0, (a, b) -> a + b);
        expressionExecutor.executeExpression(1.5, 2.0, (a, b) -> a - b);
        expressionExecutor.executeExpression(1.5, 2.0, (a, b) -> a * b);
        expressionExecutor.executeExpression(1.5, 2.0, (a, b) -> a / b);

        expressionExecutor.executeExpression(1.5, 2.0, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(1.5, 2.0, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(1.5, 2.0, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(1.5, 2.0, FunctionalCalculator::divideAByB);

        System.out.println("7.1 Text beautifier");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("Bubu", String::toUpperCase);
        poemBeautifier.beautify("Hello world!", (s) -> "ABC" + s + "ABC");
        poemBeautifier.beautify("Kodilla course module 7 submodule 1", (s) -> {
            String[] array = s.toLowerCase().split(" ");
            String decoratedString = array[0];
            for (int i = 1; i < array.length; i++) {
                decoratedString += "-" + array[i];
            }
            return decoratedString;
        });
        poemBeautifier.beautify("New text", (s) -> "\"" + s + "\"");

        System.out.println("7.2 Stream");
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}
