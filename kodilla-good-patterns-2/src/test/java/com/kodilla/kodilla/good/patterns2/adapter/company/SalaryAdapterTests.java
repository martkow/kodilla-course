package com.kodilla.kodilla.good.patterns2.adapter.company;

import com.kodilla.kodilla.good.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests for SalaryAdapter class")
public class SalaryAdapterTests {
    @Test
    void shouldReturnTotalSalary() {
        // Given
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        Workers workers = new Workers();
        // When
        double result = salaryAdapter.totalSalary(workers.getWorkers(), workers.getSalaries());
        // Then
        Assertions.assertEquals(27750.0, result, 0);
    }
}
