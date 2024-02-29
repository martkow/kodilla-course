package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@DisplayName("Tests for Board class")
public class BoardTestSuite {
    @DisplayName("Test data preparation")
    private Board prepareTestData() {
        //users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperature from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));

        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        //board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @DisplayName("Test case for addTaskList method")
    @Test
    void testCaseForAddTaskListMethod() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        Assertions.assertEquals(3, project.getTaskLists().size());
    }

    @DisplayName("Test case for looking for user tasks")
    @Test
    void testCaseForAddTaskListMethodFindUserTasks() {
        // Given
        Board project = prepareTestData();
        User user = new User("developer1", "John Smith");
        // When
        List<Task> result = project.getTaskLists().stream()
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getAssignedUser().equals(user))
                .collect(Collectors.toList());
        // Then
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(user, result.get(0).getAssignedUser());
        Assertions.assertEquals(user, result.get(1).getAssignedUser());
    }

    @DisplayName("Test case for looking for overdue tasks")
    @Test
    void testCaseForAddTaskListMethodFindOverdueTasks() {
        // Given
        Board project = prepareTestData();
        TaskList taskListDone = new TaskList("Done");
        // When
        List<Task> result = project.getTaskLists().stream()
                .filter(tl -> !tl.equals(taskListDone))
                .flatMap(tl -> tl.getTasks().stream())
                .filter(t -> t.getDeadline().isBefore(LocalDate.now()))
                .toList();
        // Then
        Assertions.assertEquals(1, result.size());
        Assertions.assertTrue(result.get(0).getTitle().equals("HQLs for analysis"));
    }

    @DisplayName("Test case for looking for tasks performed for at least 10 days")
    @Test
    void testCaseForAddTaskListMethodFindTasksPerformedForAtLeast10Days() {
        // Given
        Board project = prepareTestData();
        TaskList taskListInProgress = new TaskList("In progress");
        // When
        List<Task> result = project.getTaskLists().stream()
                .filter(tl -> tl.equals(taskListInProgress))
                .flatMap(tl -> tl.getTasks().stream())
//                .filter(t -> t.getCreated().plusDays(10L).isBefore(LocalDate.now()) || t.getCreated().plusDays(10L).isEqual(LocalDate.now()))
//                .filter(t -> t.getCreated().compareTo(LocalDate.now().minusDays(10L)) <= 0)
                .filter(t -> !t.getCreated().isAfter(LocalDate.now().minusDays(10L)))
                .toList();
        // Then
        System.out.println(result);
        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.get(0).getTitle().equals("HQLs for analysis") || result.get(0).getTitle().equals("Own logger"));
    }

    @DisplayName("Test case for looking for average number of days from creating task to now for tasks are being in progress")
    @Test
    void testCaseForAddTaskListMethodFindAverageNumberOfDaysForPerformingTaskInProgress() {
        // Given
        Board project = prepareTestData();
        TaskList taskListInProgress = new TaskList("In progress");
        // When - first approach
        long sum = project.getTaskLists().stream()
                .filter(tl -> tl.equals(taskListInProgress))
                .flatMap(tl -> tl.getTasks().stream())
                .map(t -> t.getCreated().until(LocalDate.now(), DAYS))
                .reduce(0L, Long::sum);

        long numberOfElements = project.getTaskLists().stream()
                .filter(tl -> tl.equals(taskListInProgress))
                .flatMap(tl -> tl.getTasks().stream())
                .count();
        double result1 = (double)sum / numberOfElements;
        // When - second approach
        double result2 = project.getTaskLists().stream()
                .filter(tl -> tl.equals(taskListInProgress))
                .flatMap(tl -> tl.getTasks().stream())
                .map(t -> t.getCreated().until(LocalDate.now(), DAYS))
                .mapToInt(Long::intValue)
                .average()
                .getAsDouble();
        // Then
        Assertions.assertEquals(10, result1);
        Assertions.assertEquals(10, result2);
    }
}
