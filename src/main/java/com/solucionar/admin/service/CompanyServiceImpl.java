package com.solucionar.admin.service;

import com.solucionar.admin.dao.CompanyDao;
import com.solucionar.admin.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("CompanyService")
@Transactional
public class CompanyServiceImpl extends BaseService implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Value("http://localhost:8090")
    private String systemWebAddress;

    @Override
    public Company findByCmpCode(int cmpCode) {
        return companyDao.findByCmpCode(cmpCode);
    }

    @Override
    public List<Company> findAll() {
        return companyDao.findAll();
    }

    @Override
    public void add(Company company) {
        companyDao.save(company);
    }

    @Override
    public void update(Company company) {
        companyDao.save(company);
    }
}
