package com.solucionar.admin.dao;

import com.solucionar.admin.model.Company;
import com.solucionar.admin.model.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyDao extends JpaRepository<Company, Integer> {
    Company findByCmpCode(int cmpCode);

    @Query("select c from Company c ORDER BY cmpName")
    List<Company> findAll();

    @Query("select count(c) from Company c")
    long countActive();
}
