package com.jabanto.spring.jwt.Model;

/**
 * Structure of the response when the authentication /login method is validate
 * with the valid jwt json value
 */
public class AuthenticationResponse {

    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
