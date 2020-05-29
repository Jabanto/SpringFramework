package com.jabanto.spring.SpringMVc.Config;


import com.jabanto.spring.SpringMVc.Filter.JwtRequestFilter;
import com.jabanto.spring.SpringMVc.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    /** Using configure() override method from @see{WebSecurityConfigurerAdapter}
     *  method to set values to the authentication manager builder
     *  that meants , spring will call our defined myUserDetailService and compare the give
     *  password and username with the store on the DB, and if if valid authentication will be successful
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailService);
    }

    /**
     * To avoid authentication in all request that by default the spring security apply
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // we override the configure method to disable the cross-site request forgery and then authorizes request for /login for every body
        // but another request well need to be authenticate
        // we say here Spring hey for these particular endPoint dont use authentication but for the rest yes
        http.csrf().disable()
                .authorizeRequests().antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                // Here VERY IMPORTANT we say spring don't manage sessions and just respond/work for each request and set up the security context each time as well
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // Here we call the filter that we created , we define here that the jwt valid filter is called before the user name/password Filter its call
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    /*
    In new versions of spring boot we need to define a bean of Authentication Manager in order that the autowired
    works
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * We choose the NoOpPassword encoder , to avoid that Spring treats the password with hash/encryption
     * just for testing for the API
     * @return Password encoder to work with it as a plain Text
     * TODO Activate hashing of the password for the credentials too
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
