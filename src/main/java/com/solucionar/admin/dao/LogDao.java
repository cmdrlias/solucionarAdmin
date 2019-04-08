package com.solucionar.admin.dao;

import com.solucionar.admin.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogDao extends JpaRepository<Log, Integer> {
    @Query("select l from Log l ORDER BY l.logCode DESC")
    List<Log> findAll();

}
