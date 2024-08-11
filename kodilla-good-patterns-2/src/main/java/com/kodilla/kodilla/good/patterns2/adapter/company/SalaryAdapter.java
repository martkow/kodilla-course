package com.kodilla.kodilla.good.patterns2.adapter.company;

import com.kodilla.kodilla.good.patterns2.adapter.company.newhrsystem.Employee;
import com.kodilla.kodilla.good.patterns2.adapter.company.oldhrsystem.SalaryCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Next, the Adaptee class is extended (through inheritance by the Adapter class), and functionalities specific to the interface expected by the calling system are added. Inside the adapter methods, data transformation occurs, and calls are passed to the "internal class" Adaptee.<br><br>
 *
 * This class simultaneously:
 *
 * Extends the SalaryAdaptee class (through inheritance), thereby gaining access to the methods of the SalaryAdaptee class as if they were its own.
 * Implements the SalaryCalculator interface expected by the old system, thus creating methods that the old system can call.
 */
public class SalaryAdapter extends SalaryAdaptee implements SalaryCalculator {

    @Override
    public double totalSalary(String[][] workers, double[] salaries) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < workers.length; i++) {
            employees.add(new Employee(
                    workers[i][0],
                    workers[i][1],
                    workers[i][2],
                    new BigDecimal(salaries[i])));
        }

        return calculateSalaries(employees).doubleValue();
    }
}
