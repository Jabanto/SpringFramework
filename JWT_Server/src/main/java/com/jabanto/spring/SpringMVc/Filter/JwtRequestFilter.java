package com.jabanto.spring.SpringMVc.Filter;

import com.jabanto.spring.SpringMVc.Service.MyUserDetailsService;
import com.jabanto.spring.SpringMVc.Service.JwtUtilService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * These filter is goiung to intercep every request just once and then examine the header
 * extended the OncePerRequestfilter
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtilService jwtUtil;

    /** Examine the coming request see the jwt , and if these are valid
     * its gonna  get the user details out of the user detailed service
     * and saved in the security context
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {

        // 1 get the header with the authorization from the request to begin the validation of the JWT
        final String authorizationHeader = httpServletRequest.getHeader("Authorization");
        String userName = null;
        Claims allPrivilege = null;
        String jwt = null;

            // 2 Define some structure of the authorization header
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                // using JwtUtil service we can extract the username with the give JWT
                userName = jwtUtil.extractUserName(jwt);
            }

            // 3 with the user name than can i pull up the userdetails and validate the give JWT with the
            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
                if (jwtUtil.validateToken(jwt, userDetails)) {


                    // 4 with the valid token that spring simulate a normal flow of the operation
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );

                    // 5 an then we set these on the context
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                }
            }

        // when the filter its complete and continue the flow
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
