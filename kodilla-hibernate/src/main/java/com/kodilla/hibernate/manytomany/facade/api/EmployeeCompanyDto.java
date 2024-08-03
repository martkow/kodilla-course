package com.kodilla.hibernate.manytomany.facade.api;

public class EmployeeCompanyDto {
    private String companyName;

    public EmployeeCompanyDto(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "EmployeeCompanyDto{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
