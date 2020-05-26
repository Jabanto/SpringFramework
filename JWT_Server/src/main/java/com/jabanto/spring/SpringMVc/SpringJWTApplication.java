package com.jabanto.spring.SpringMVc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringJWTApplication implements CommandLineRunner {


	private static final Logger log = LoggerFactory.getLogger(SpringJWTApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(SpringJWTApplication.class, args);
	}


	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {

		log.info("Conecting to Mysql DB");

		//Split up the array of whole names into a array fo first/last names
		List<Object[]> splitUpNames = Arrays.asList("Jothn Wtoo", "Jetft Dena", "Josth BLoch", "Jtohs Long").stream()
				.map(name->name.split(" "))
				.collect(Collectors.toList());

		//Using Java 8 Stream to pritn out each tuple fo the list
		splitUpNames.forEach(name->log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

		// Use Jdbc Temaplate btach Update Operation to bulk load data

		//jdbcTemplate.batchUpdate("INSERT INTO user(login,password) VALUES (?,?)",splitUpNames);


	}
}
