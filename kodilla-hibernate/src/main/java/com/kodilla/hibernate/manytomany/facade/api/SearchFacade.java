package com.kodilla.hibernate.manytomany.facade.api;

import com.kodilla.hibernate.manytomany.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);
    private final SearchService searchService;

    @Autowired
    public SearchFacade(SearchService searchService) {
        this.searchService = searchService;
    }

    public List<CompanyDto> searchCompany(String companySearchValue) throws SearchCompanyException {
        LOGGER.info("Starting company search.");
        List<CompanyDto> companyDtoList = searchService.searchCompany(companySearchValue);

        if (companyDtoList.isEmpty()) {
            LOGGER.info("Company not found.");
            throw new SearchCompanyException(SearchCompanyException.COMPANY_NOT_FOUND);
        }

        LOGGER.info("Searched companies returned.");
        return  companyDtoList;
    }

    public List<EmployeeDto> searchEmployee(String employeeSearchValue) throws SearchEmployeeException {
        LOGGER.info("Starting employee search.");
        List<EmployeeDto> employeeDtoList = searchService.searchEmployee(employeeSearchValue);

        if (employeeDtoList.isEmpty()) {
            LOGGER.info("Employee not found.");
            throw new SearchEmployeeException(SearchEmployeeException.EMPLOYEE_NOT_FOUND);
        }

        LOGGER.info("Searched employees returned.");
        return  employeeDtoList;
    }
 }
