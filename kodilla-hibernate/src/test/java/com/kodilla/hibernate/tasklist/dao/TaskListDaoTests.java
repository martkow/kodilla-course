package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@DisplayName("Tests for TaskListDao interface - Data Object Access layer -> Repository controller")
@SpringBootTest
public class TaskListDaoTests {
    private static final String LIST_NAME = "Todo";
    private static final String LIST_DESCRIPTION = "Tasks to do.";
    private static final String TASK_DESCRIPTION = "Test: Learn Hibernate";
    private static final String TASK2_DESCRIPTION = "Test: Write some entities";
    @Autowired
    private TaskListDao taskListDao;

    @DisplayName("Test case for findByListName method")
    @Test
    void testTaskListDaoFindByListName() {
        // Given
        TaskList taskList = new TaskList(LIST_NAME, LIST_DESCRIPTION);
        taskListDao.save(taskList);
        int id = taskList.getId();
        // When
        List<TaskList> result = taskListDao.findByListName(LIST_NAME);
        // Then
        Assertions.assertEquals(1, result.size());
        // Cleanup
        taskListDao.deleteById(id);
    }

    @DisplayName("Test case for save method with saving to related table: 1:N")
    @Test
    void testTaskListDaoSaveWithTasks() {
        //Given
        Task task = new Task(TASK_DESCRIPTION, 14);
        Task task2 = new Task(TASK2_DESCRIPTION, 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskList = new TaskList(LIST_NAME, LIST_DESCRIPTION);
        taskList.getTaskList().add(task);
        taskList.getTaskList().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);
        //When
        taskListDao.save(taskList);
        int id = taskList.getId();
        //Then
        Assertions.assertNotEquals(0, id);
        //CleanUp
        taskListDao.deleteById(id);
    }
}
