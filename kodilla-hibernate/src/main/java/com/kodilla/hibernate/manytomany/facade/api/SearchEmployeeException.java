package com.kodilla.hibernate.manytomany.facade.api;

public class SearchEmployeeException extends Exception{
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found.";

    public SearchEmployeeException(String message) {
        super(message);
    }
}
