package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
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
    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";
    private static final String LIST_NAME = "Todo";
    private static final String LIST_DESCRIPTION = "ToDo tasks";

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

    @DisplayName("Test case for named queries")
    @Test
    void testNamedQueries() {
        //Given
        Task task1 = new Task("Test: Study Hibernate", 3);
        Task task2 = new Task("Test: Practice Named Queries", 6);
        Task task3 = new Task("Test: Study native queries", 7);
        Task task4 = new Task("Test: Make some tests", 13);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        TaskList taskList = new TaskList(LIST_NAME, LIST_DESCRIPTION);
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDao.save(taskList);
        int id = taskList.getId();
        //When
        List<Task> longTasks = taskDao.retrieveLongTasks();
        longTasks.forEach(System.out::println);
        List<Task> shortTasks = taskDao.retrieveShortTasks();
        List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        List<Task> durationLongerThan1Tasks = taskDao.retrieveTasksWithDurationLongerThan(1);
        //Then
        try {
            Assertions.assertEquals(1, longTasks.size());
            Assertions.assertEquals(3, shortTasks.size());
            Assertions.assertEquals(3, enoughTimeTasks.size());
            Assertions.assertEquals(4, durationLongerThan1Tasks.size());
        } finally {
            //CleanUp
            taskListDao.deleteById(id);
        }
    }
}
