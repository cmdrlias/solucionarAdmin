package com.solucionar.admin.service;

import com.solucionar.admin.model.Log;

import java.util.List;

public interface LogService {
    List<Log> findAll();

    void add(Log log);
}
