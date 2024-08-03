package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.domain.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query
    List<Employee> retrieveEmployeeByLastname(@Param("LASTNAME") String lastname);
    @Query
    List<Employee> retrieveEmployeeByAnyPartOfEmployeeLastname(@Param("VALUE") String value);
}
