package com.jabanto.spring.jwt.Controller;

import com.jabanto.spring.jwt.Model.AuthenticationRequest;
import com.jabanto.spring.jwt.Model.AuthenticationResponse;
import com.jabanto.spring.jwt.Model.UserModel;
import com.jabanto.spring.jwt.Repository.RoleUserRepo;
import com.jabanto.spring.jwt.Service.MyUserDetailsService;
import com.jabanto.spring.jwt.Service.JwtUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class JWT_MainControler {

    @Autowired
    private RoleUserRepo roleUserRepo;

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
        return "Welcome jabanto";
    }

    /**
     * We create login endpoint that no redirect to any place but accepts the user Id and Password and use it
     * to generate a JWT token as a respond in the payload
     * We sume that the client hold on to that jwt and sends it in other subsequent request in the header
     * @param authenticationRequest
     * @return JWT json Token
     * @throws Exception
     */
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        // in order to authenticate we need to get a handle to the authentication manager, using a menber variable og the authentication manager
        // that will be autowire an we use it these manager in order to authenticate a new username and password authentication token
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            // TODO see the fail on the message of the payload
        }catch (BadCredentialsException e){
            throw  new Exception("Incorrect username or password",e );
        }
        // the here the authentication it is successful here the methods create and returns the JWT
        // in the pay load response

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtilService.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    // create a explicitly an specify a POST endpoints for login using UI provide by Spring Security Model
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    @PostMapping("/user")
    public String createUser(){
        UserModel userModel = new UserModel("createdLogin2","test123","fnameTest","lnameTest","emailTest2");
        roleUserRepo.createUser(userModel.getLogin(),userModel.getPassword(),userModel.getfName(),userModel.getlName(),userModel.geteMail());
        return "User with credentials" + userModel.toString() + "created";
    }

    // Update User Information
    @PreAuthorize("hasAuthority('UPDATE_PRIVILEGE')")
    @PutMapping("/user/{id}")
    public String updateUser(@PathVariable("id") Long id){
        roleUserRepo.updateUser(id,"clientTest4");
        UserModel userModel = roleUserRepo.findUserById(id);
        return "User Updated : " + userModel.toString();
    }

    // create a explicitly an specify a POST endpoints for login using UI provide by Spring Security Model
    // , We can use too RequestMapping that map all HTTP operations
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    @GetMapping("/user/{id}")
    public String login(@PathVariable("id") Long id) {
        String result =  roleUserRepo.findUserById(id).toString();
        return "User Information ACL " + result;
    }

    // Create a explicit Delete endpoints to delete User by Id
    @PreAuthorize("hasAuthority('DELETE_PRIVILEGE')")
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        roleUserRepo.deleteUserById(id);
        return "User with Id: " + id  +" was deleted from DB";
    }


}