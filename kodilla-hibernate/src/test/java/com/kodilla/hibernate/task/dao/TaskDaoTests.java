package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.dao.TaskListDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@DisplayName("Tests for TaskDao interface - Data Object Access layer -> Repository controller")
@SpringBootTest
public class TaskDaoTests {
    @Autowired
    private TaskDao taskDao;

    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @DisplayName("Test case for save method")
    @Test
    void testTaskDaoSave() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        //When
        taskDao.save(task);
        //Then
        int id = task.getId();
        Optional<Task> readTask = taskDao.findById(id);
        Assertions.assertTrue(readTask.isPresent());
        //CleanUp
        taskDao.deleteById(id);
    }

    @DisplayName("Test case for findByDuration method")
    @Test
    void testTaskDaoFindByDuration() {
        //Given
        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();
        //When
        List<Task> readTasks = taskDao.findByDuration(duration);
        //Then
        Assertions.assertEquals(1, readTasks.size());
        //CleanUp
        int id = readTasks.get(0).getId();
        taskDao.deleteById(id);
    }

    @DisplayName("Test case for save method with saving to related table: 1:1")
    @Test
    void testTaskDaoSaveWithFinancialDetails() {
        //Given
        Task task = new Task(DESCRIPTION, 30);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(120), false));
        //When
        taskDao.save(task);
        int id = task.getId();
        //Then
        Assertions.assertNotEquals(0, id);
        //CleanUp
        taskDao.deleteById(id);
    }
}
