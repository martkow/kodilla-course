package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.domain.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(nativeQuery = true)
    List<Company> retrieveCompanyByFirstThreeCharactersOfCompanyName(@Param("THREECHARACTERS") String threeCharacters);
    @Query
//    List<Company> retrieveCompanyByAnyPartOfCompanyName(@Param("VALUE") String value);
    List<Company> retrieveCompanyByAnyPartOfCompanyName(@Param("ARG") String value);
}
