package com.jabanto.spring.SpringMVc.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Class to abstract out all the JWT related Stuff to create JWT-abilities given the UserDetailsObject
 * and pull up information from a existing JWT ability, like look up expiration Date / UserName and etc jwt Abilities
 */
@Service
public class JwtUtilService {

    private String SECRET_KEY = "InterNetX";

    // to pull information of the exited token, here to pull subject information
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // To pull information about the token, in these case the data of expiration
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //WHY not private
    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }


    /**
     * To check up of the token its expire or not
     * @param token
     * @return boolean
     */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * The most important method here create hash token on plain Text format of the UserDetails
     * here using the UserName,
     * @param userDetails
     * @return generated JWT token
     */
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put("Authorities", userDetails.getAuthorities());
        return createToken(claims, userDetails.getUsername());
    }

    /**
     * Create the JWT Token using the JWTS builder, the UserName,
     * the date of creation of the token and defined date of expiration (10 hours for current Time)
     * Definition of the signature Algorithm for the creation of the token
     * TODO Import Secret Key from property file or Data Base
     * @param claims any one more information that we wanna add on the payload
     * @param subject in this case the UserName
     * @return create token base on the over described information
     */
    private String createToken(Map<String, Object> claims, String subject){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    // Extract the user name from the token and compares with the give User details username
    // and that que token it is not expired
    public Boolean validateToken(String token, UserDetails userDetails){
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }



}
