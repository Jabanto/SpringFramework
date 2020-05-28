package com.jabanto.spring.SpringMVc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@RestController
public class JWT_MainControler {

    // create a explicitly an specify a POST endpoints for login using UI provide by Spring Security Model
    @PostMapping("/user")
    public String createUser(){
        return "User created";
    }

    // Update User Information
    @PutMapping("/user/{id}")
    public String updateUser(){
        return "User Updated";
    }

    // create a explicitly an specify a POST endpoints for login using UI provide by Spring Security Model
    // , We can use too RequestMappin that map all HTTP operations
    @GetMapping("/user/{id}")
    public String login(PathVariable id) {
        return "User Information ACL " + id.name();
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(PathVariable id){

        return "User was deleted from DB";
    }

    
}