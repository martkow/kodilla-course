package com.kodilla.hibernate.manytomany.facade.api;

public class SearchCompanyException extends Exception {
    public static final String COMPANY_NOT_FOUND = "Company not found.";

    public SearchCompanyException(String message) {
        super(message);
    }
}
