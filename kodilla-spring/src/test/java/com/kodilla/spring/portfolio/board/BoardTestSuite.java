package com.kodilla.spring.portfolio.board;

import com.kodilla.spring.portfolio.board.Board;
import com.kodilla.spring.portfolio.board.BoardConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

@DisplayName("Tests for Board class")
@SpringBootTest
public class BoardTestSuite {
    @DisplayName("Test case for board bean")
    @Test
    void testBoardBean() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        // When
        boolean result = context.containsBean("board");
        // Then
        Assertions.assertTrue(result);
    }

    @DisplayName("Test case for addTask method")
    @Test
    void testCaseForAddTaskMethod() {
        // Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = (Board) context.getBean("board");
        // When
        board.addTask("Task to do", board.getToDoList());
        board.addTask("Task in progress", board.getInProgressList());
        board.addTask("Task done", board.getDoneList());
        // Then
        Stream.of(board.getToDoList(), board.getInProgressList(), board.getDoneList())
                .flatMap(tl -> tl.getTasks().stream())
                .forEach(System.out::println);
    }
}
