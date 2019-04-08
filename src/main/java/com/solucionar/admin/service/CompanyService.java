package com.solucionar.admin.service;

import com.solucionar.admin.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    Company findByCmpCode(int cmpCode);

    void add(Company company);

    void update(Company company);

    void delete(Company company);

    long count();
}
