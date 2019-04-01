package com.solucionar.admin.service;

import com.solucionar.admin.dao.NewsDao;
import com.solucionar.admin.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("NewsService")
@Transactional
public class NewsServiceImpl extends BaseService implements NewsService {
   @Autowired
   private NewsDao newsDao;

   @Override
   public News findByNwsCode(int nwsCode) {
       return newsDao.findByNwsCode(nwsCode);
   }

   @Override
    public List<News> findAll() {
       return newsDao.findAll();
   }

   @Override
    public void add(News news) {
       news.setNwsCreatedAt(new Date());
       newsDao.save(news);
   }
}
