package com.jabanto.spring.SpringMVc.Service;

import com.jabanto.spring.SpringMVc.Model.UserModel;
import com.jabanto.spring.SpringMVc.SpringJWTApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


/**
 * We create our specifically UserDetails Service implementing UserDetailService Interface
 * , and override the loadUserByUserName method and acces to the information of the user in the mysql data base
 * using JDBC template to charge/mapping the required on the User model class
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    /**
     * Load the user Information base on the data saved on the mysql DB
     * @param userName
     * @return The information of the User charge on a User that implements UserDetails Interface
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //TODO import information fron DB
        UserModel admin = new UserModel(1,"admin","pass","jabanto","jabanto","Jabanto@interNet.de");
        return new User(admin.getfName(),admin.getPassword(),new ArrayList<>());
    }
}
