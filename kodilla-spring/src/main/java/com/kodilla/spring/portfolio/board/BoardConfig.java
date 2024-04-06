package com.kodilla.spring.portfolio.board;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {
    @Bean(name = "taskList")
    @Scope("prototype")
    public TaskList createTaskList() {
        return new TaskList();
    }

    @Bean(name = "board")
    public Board createBoard() {
        return new Board(createTaskList(), createTaskList(), createTaskList());
    }
}
