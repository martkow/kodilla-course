package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        System.out.println("7.3 Stream functions");
        People.getList().stream()
                .map(String::toUpperCase)
                .filter((s) -> s.length() > 11)
                .map((s) -> s.substring(0, s.indexOf(" ") + 2) + ".")
                .filter((s) -> s.charAt(0) == 'M')
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> listOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getPublicationYear() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + listOfBooks.size());
        listOfBooks.stream().forEach(System.out::println);

        Map<String, Book> mapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getPublicationYear() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + mapOfBooks.size());
        mapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        String resultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getPublicationYear() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(resultStringOfBooks);

        Forum forum = new Forum();
        Map<Integer, ForumUser> mapOfForumUsers = forum.getUserList().stream()
                .filter(u -> u.getSex() == 'M')
                .filter(u -> LocalDate.now().getYear() - u.getBirthdate().getYear() >= 20)
                .filter(u -> u.getPublishedPostsNumber() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, u -> u));

        System.out.println("# elements: " + mapOfForumUsers.size());
        mapOfForumUsers.entrySet().stream()
                .forEach(System.out::println);
    }
}
