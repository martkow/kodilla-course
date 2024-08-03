package com.kodilla.hibernate.manytomany.facade.api;

import java.util.List;

public final class EmployeeDto {
    private String firstname;
    private String lastname;
    private List<EmployeeCompanyDto> employeeCompanyDtoList;

    public EmployeeDto(String firstname, String lastname, List<EmployeeCompanyDto> employeeCompanyDtoList) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.employeeCompanyDtoList = employeeCompanyDtoList;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", employeeCompanyDtoList=" + employeeCompanyDtoList +
                '}';
    }
}
