package com.kodilla.hibernate.manytomany.facade.api;

import java.util.ArrayList;
import java.util.List;

public final class CompanyDto {
    private String companyName;
    private List<EmployeeDto> employeeDtoList = new ArrayList<>();

    public CompanyDto(String companyName, List<EmployeeDto> employeeDtoList) {
        this.companyName = companyName;
        this.employeeDtoList = employeeDtoList;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "companyName='" + companyName + '\'' +
                ", employeeDtoList=" + employeeDtoList +
                '}';
    }
}
