package com.jabanto.spring.jwt;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringMVcApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	/**
	 * We use the @SpringBootTest annotation , cuz we want the entire context to be created
	 * without starting the server, with that in place, we can then add the @AutoConfigureMock to inject MockMvc
	 * instance and send HTTP requests
	 */
	@Test
	public void whenTestApp_theEmptyResponse() throws Exception {
		this.mockMvc.perform(post("/login"))
				.andExpect(status().isBadRequest());
	}

}
