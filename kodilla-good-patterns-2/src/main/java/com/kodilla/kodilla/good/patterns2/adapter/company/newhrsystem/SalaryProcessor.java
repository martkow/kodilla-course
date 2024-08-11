package com.kodilla.kodilla.good.patterns2.adapter.company.newhrsystem;

import java.util.List;
import java.math.BigDecimal;

public interface SalaryProcessor {
    BigDecimal calculateSalaries(List<Employee> employees);
}
