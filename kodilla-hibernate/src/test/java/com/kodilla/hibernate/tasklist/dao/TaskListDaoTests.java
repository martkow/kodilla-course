package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@DisplayName("Tests for TaskListDao interface - Data Object Access layer -> Repository controller")
@SpringBootTest
public class TaskListDaoTests {
    private static final String LIST_NAME = "Todo";
    private static final String DESCRIPTION = "Tasks to do.";
    @Autowired
    private TaskListDao taskListDao;

    @DisplayName("Test case for findByListName method")
    @Test
    void testTaskListDaoFindByListName() {
        // Given
        TaskList taskList = new TaskList(LIST_NAME, DESCRIPTION);
        taskListDao.save(taskList);
        int id = taskList.getId();
        // When
        List<TaskList> result = taskListDao.findByListName(LIST_NAME);
        // Then
        Assertions.assertEquals(1, result.size());
        // Cleanup
        taskListDao.deleteById(id);
    }
}
