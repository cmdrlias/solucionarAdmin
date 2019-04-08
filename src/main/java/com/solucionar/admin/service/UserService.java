package com.solucionar.admin.service;

import com.solucionar.admin.model.User;
import com.solucionar.admin.model.UserType;

import java.util.List;

public interface UserService {

    List<UserType> findUserTypes();

    UserType findUserTypeById(Integer ustType);

    List<User> findAll();

    void add(User user);

    void update(User user);

    User findByUsrCode(int usrCode);

    User findByUsrEmail(String usrEmail);

    User findByUsrName(String usrName);

    long count();

}
