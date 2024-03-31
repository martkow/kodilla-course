package com.kodilla.spring.portfolio.board;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {
    @Bean(name = "toDoList")
    public TaskList createToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    public TaskList createInProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    public TaskList createDoneList() {
        return new TaskList();
    }

    @Bean(name = "board")
    public Board createBoard() {
        return new Board(createToDoList(), createInProgressList(), createDoneList());
    }
}
