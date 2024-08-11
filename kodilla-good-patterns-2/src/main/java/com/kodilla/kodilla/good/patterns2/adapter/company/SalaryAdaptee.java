package com.kodilla.kodilla.good.patterns2.adapter.company;

import com.kodilla.kodilla.good.patterns2.adapter.company.newhrsystem.CompanySalaryProcessor;
import com.kodilla.kodilla.good.patterns2.adapter.company.newhrsystem.Employee;
import com.kodilla.kodilla.good.patterns2.adapter.company.newhrsystem.SalaryProcessor;

import java.math.BigDecimal;
import java.util.List;

/**
 * Adapter pattern: In practice, a common solution involves creating an Adaptee class that "wraps" method calls of the target system. This is achieved by implementing the interface of the called system in the Adaptee class in such a way that this class calls the appropriate methods provided by the called system (the Adaptee class becomes a wrapper for these methods).<br><br>
 * Class implements the interface of the called system (i.e., the new payroll system)
 */
public class SalaryAdaptee implements SalaryProcessor {
    @Override
    public BigDecimal calculateSalaries(List<Employee> employees) {
        CompanySalaryProcessor companySalaryProcessor = new CompanySalaryProcessor();
        return companySalaryProcessor.calculateSalaries(employees);
    }
}
