package com.kodilla.hibernate.manytomany.facade.api;

import com.kodilla.hibernate.manytomany.domain.Company;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyToCompanyDtoMapper {
    public static List<CompanyDto> mapToCompanyDto(List<Company> companyList) {
        return companyList.stream().map(c -> mapToCompanyDto(c)).toList();
    }

    public static CompanyDto mapToCompanyDto(Company company) {
        return new CompanyDto(company.getCompanyName(), EmployeeToEmployeeDtoMapper.mapToEmployeeDto(company.getEmployees()));
    }
}
