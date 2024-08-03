package com.kodilla.hibernate.manytomany.facade.api;

import com.kodilla.hibernate.manytomany.domain.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeToEmployeeDtoMapper {
    public static List<EmployeeDto> mapToEmployeeDto(List<Employee> employeeList) {
        return employeeList.stream().map(e -> mapToEmployeeDto(e)).toList();
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getFirstname(),
                employee.getLastname(),
                employee.getCompanies().stream()
                        .map(c -> c.getCompanyName())
                        .map(cn -> new EmployeeCompanyDto(cn))
                        .toList());
    }
}
