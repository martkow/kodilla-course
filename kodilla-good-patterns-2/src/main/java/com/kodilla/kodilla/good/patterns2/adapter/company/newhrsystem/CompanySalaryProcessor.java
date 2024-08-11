package com.kodilla.kodilla.good.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.List;

public class CompanySalaryProcessor implements SalaryProcessor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        return employees.stream()
                .map(e -> {
                    System.out.println(e);
                    return e.getBaseSalary();
                })
                .reduce(BigDecimal.ZERO, (s1, s2) -> {
                    return s1.add(s2);
                } );
    }
}
