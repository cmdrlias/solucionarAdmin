package com.solucionar.admin.dao;

import com.solucionar.admin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsrCode(int usrCode);

    User findByUsrEmail(String usrEmail);

    User findByUsrName(String usrName);

    @Query("select u from User u ORDER BY usrName")
    List<User> findAll();
}
