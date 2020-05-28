package com.jabanto.spring.SpringMVc.Service;

import com.jabanto.spring.SpringMVc.Model.UserModel;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //TODO import information fron DB
        UserModel admin = new UserModel(1,"admin","pass","jabanto","jabanto","Jabanto@interNet.de");
        // User implements User details interface
        return new User("foo","foo",new ArrayList<>());
    }
}
