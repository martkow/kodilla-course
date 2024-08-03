package com.kodilla.hibernate.manytomany.service;

import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import com.kodilla.hibernate.manytomany.facade.api.CompanyDto;
import com.kodilla.hibernate.manytomany.facade.api.CompanyToCompanyDtoMapper;
import com.kodilla.hibernate.manytomany.facade.api.EmployeeDto;
import com.kodilla.hibernate.manytomany.facade.api.EmployeeToEmployeeDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class SearchService {
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;
    private final EmployeeToEmployeeDtoMapper employeeToEmployeeDtoMapper;
    private final CompanyToCompanyDtoMapper companyToCompanyDtoMapper;

    @Autowired
    public SearchService(CompanyDao companyDao, EmployeeDao employeeDao, EmployeeToEmployeeDtoMapper employeeToEmployeeDtoMapper, CompanyToCompanyDtoMapper companyToCompanyDtoMapper) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
        this.employeeToEmployeeDtoMapper = employeeToEmployeeDtoMapper;
        this.companyToCompanyDtoMapper = companyToCompanyDtoMapper;
    }

    public List<EmployeeDto> searchEmployee(String searchValue) {
        return employeeToEmployeeDtoMapper.mapToEmployeeDto(employeeDao.retrieveEmployeeByAnyPartOfEmployeeLastname("%" + searchValue + "%"));
    }

    public List<CompanyDto> searchCompany(String searchValue) {
        return companyToCompanyDtoMapper.mapToCompanyDto(companyDao.retrieveCompanyByAnyPartOfCompanyName("%" + searchValue + "%"));
    }
}
