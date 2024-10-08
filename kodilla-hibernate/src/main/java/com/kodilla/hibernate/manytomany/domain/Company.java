package com.kodilla.hibernate.manytomany.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "Company.retrieveCompanyByFirstThreeCharactersOfCompanyName",
        query = "SELECT * FROM COMPANIES WHERE SUBSTRING(COMPANY_NAME, 1, 3) = :THREECHARACTERS",
        resultClass = Company.class
)
@NamedQuery(
        name = "Company.retrieveCompanyByAnyPartOfCompanyName",
    //    query = "FROM Company WHERE companyName LIKE :VALUE"
        query = "FROM Company WHERE companyName LIKE CONCAT('%',:ARG,'%')"
)
@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String companyName;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String companyName) {
        this.companyName = companyName;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
