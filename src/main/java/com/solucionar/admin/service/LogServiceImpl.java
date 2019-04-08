package com.solucionar.admin.service;

import com.solucionar.admin.dao.LogDao;
import com.solucionar.admin.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("LogService")
@Transactional
public class LogServiceImpl extends BaseService implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public List<Log> findAll() {
        return logDao.findAll();
    }

    @Override
    public void add(Log log) {
        log.setLogCreatedAt(new Date());
        logDao.save(log);
    }
}
