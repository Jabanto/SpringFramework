package com.jabanto.spring.jwt;
import com.jabanto.spring.jwt.Config.SecurityConfig;
import com.jabanto.spring.jwt.Controller.JWT_MainControler;
import com.jabanto.spring.jwt.Repository.RoleUserRepo;
import com.jabanto.spring.jwt.Service.JwtUtilService;
import com.jabanto.spring.jwt.Service.MyUserDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(JWT_MainControler.class)
public class MainControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoleUserRepo userRepo;

    @MockBean
    private MyUserDetailsService myUserDetailsService;

    @MockBean
    private JwtUtilService jwtTokenUtilService;

    /**
     * To avoid creating the whole context and test only our MVC Controllers we use @WebMvcTest
     * and using @Mockbean to load trought mock the required beans used on the Controller for the Test
     */
    @Test
    public void whenTestController_thenRetrieveExpectedResult() throws Exception {

        this.mockMvc.perform(post("/user"))
                .andExpect(status().isForbidden());

    }


}
