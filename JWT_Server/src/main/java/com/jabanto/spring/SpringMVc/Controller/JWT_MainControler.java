package com.jabanto.spring.SpringMVc.Controller;

import com.jabanto.spring.SpringMVc.Model.AuthenticationRequest;
import com.jabanto.spring.SpringMVc.Model.AuthenticationResponse;
import com.jabanto.spring.SpringMVc.Service.MyUserDetailsService;
import com.jabanto.spring.SpringMVc.Service.JwtUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class JWT_MainControler {

    @Autowired
    private MyUserDetailsService userDetailsService;
    //
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilService jwtTokenUtilService;

    // Test Method for https Get Request
    @GetMapping("/hello")
    public String test(){
        return "Welcome to jabanto";
    }

    /**
     * We create login endpoint that no redirect to any place but accepts the user Id and Password and use it
     * to generate a JWT token as a respond in the payload
     * We sume that the client hold on to that jwt and sends it in other subsequent request in the header
     * @param authenticationRequest
     * @return JWT jason Token
     * @throws Exception
     */
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        // in order to authenticate we need to get a handle to the authentication manager, using a menber variable og the authentication manager
        // that will be autowire an we use it these manager in order to authenticate a new username and password authentication token
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
            );
            // TODO seee the fail on the message of the payload
        }catch (BadCredentialsException e){
            throw  new Exception("Incorrect username or password", e);
        }
        // the here the authentication it is successful here the methods create and returns the JWT
        // in the pay load response

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());

        final String jwt = jwtTokenUtilService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

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