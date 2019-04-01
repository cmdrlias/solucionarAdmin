package com.solucionar.admin.service;

import com.solucionar.admin.model.News;

import java.util.List;

public interface NewsService {
    News findByNwsCode(int nwsCode);

    List<News> findAll();

    void add(News news);
}
