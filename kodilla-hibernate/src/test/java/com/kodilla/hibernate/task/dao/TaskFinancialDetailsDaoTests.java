package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@DisplayName("Tests for TaskDao interface - Data Object Access layer -> Repository controller")
@SpringBootTest
public class TaskFinancialDetailsDaoTests {
    @Autowired
    private TaskFinancialDetailsDao taskFinancialDetailsDao;

    @DisplayName("Test case for findByPaid method")
    @Test
    void testFindByPaid() {
        // Given
        TaskFinancialDetails taskFinancialDetails = new TaskFinancialDetails(new BigDecimal(115), false);
        taskFinancialDetailsDao.save(taskFinancialDetails);
        int id = taskFinancialDetails.getId();
        // When
        List<TaskFinancialDetails> result = taskFinancialDetailsDao.findByPaid(false);
        // Then
        Assertions.assertEquals(1, result.size());
        // Cleanup
        taskFinancialDetailsDao.deleteById(id);
    }
}
