package com.jabanto.spring.SpringMVc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JWT_MainControler {

    // create a explicitly an specify a POST endpoints for login using UI provide by Spring Security Model
    // , We can use too RequestMappin that map all HTTP operations
    @PostMapping ({"/login"})
    public String login(){
        return "Welcome to jwt";
    }

    // create a explicitly an specify a POST endpoints for login using UI provide by Spring Security Model
    // , We can use too RequestMapping that map all HTTP operations

}
