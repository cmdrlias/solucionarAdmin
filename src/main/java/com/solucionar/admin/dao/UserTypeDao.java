package com.solucionar.admin.dao;

import com.solucionar.admin.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeDao extends JpaRepository<UserType, Integer> {
}
