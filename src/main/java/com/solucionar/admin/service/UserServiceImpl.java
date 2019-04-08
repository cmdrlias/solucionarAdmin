package com.solucionar.admin.service;

import com.solucionar.admin.dao.NewsDao;
import com.solucionar.admin.dao.UserDao;
import com.solucionar.admin.dao.UserTypeDao;
import com.solucionar.admin.model.User;
import com.solucionar.admin.model.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("UserService")
@Transactional
public class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeDao userTypeDao;

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private NewsService newsService;

    @Value("${system.web.address}")
    private String systemWebAddress;

    @Override
    public List<UserType> findUserTypes() {
        return userTypeDao.findAll();
    }

    @Override
    public UserType findUserTypeById(Integer ustType) {
        return userTypeDao.findById(ustType).get();
    }

    @Override
    public User findByUsrCode(int usrCode) {
        return userDao.findByUsrCode(usrCode);
    }

    @Override
    public User findByUsrEmail(String usrEmail) {
        return userDao.findByUsrEmail(usrEmail);
    }

    @Override
    public User findByUsrName(String usrName) {
        return userDao.findByUsrName(usrName);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }

    @Override
    public long count() {
        return userDao.countActive();
    }
}
