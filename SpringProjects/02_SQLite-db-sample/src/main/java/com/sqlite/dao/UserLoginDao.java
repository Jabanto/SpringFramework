package com.sqlite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sqlite.entities.UserLogin;

/**
 *
 */
public interface UserLoginDao extends JpaRepository<UserLogin, Long> {

   UserLogin findUserLoginByUserNameAndPassword(String username,String password);

}
