package com.kodilla.spring.portfolio.board;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public void addTask(String task, TaskList taskList) {
        taskList.addTask(task);
    }
}
