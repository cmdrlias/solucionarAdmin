package com.solucionar.admin.dao;

import com.solucionar.admin.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsDao extends JpaRepository<News, Integer> {
    News findByNwsCode(int nwsCode);

    @Query("select n from News n ORDER BY nwsCode DESC")
    List<News> findAll();
}
