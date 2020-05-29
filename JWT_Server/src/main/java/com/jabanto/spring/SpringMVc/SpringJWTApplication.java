package com.jabanto.spring.SpringMVc;

import com.jabanto.spring.SpringMVc.Model.UserModel;
import jdk.nashorn.internal.runtime.ListAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
	// Test Of jdbc Conection
	@Override
	public void run(String... args) throws Exception {


		UserModel admin = new UserModel(1,"admin","pass","jabanto","jabanto","Jabanto@interNet.de");
		log.info("Conecting to Mysql DB");

		//Split up the array of whole names into a array fo first/last names
        /* List<Object[]> splitUpNames =
                Arrays.asList("Jothn Wtoo",
                              "Jetft Dena", "Josth BLoch", "Jtohs Long").stream()
                .map(name->name.split(" "))
                .collect(Collectors.toList());

        */

		List<UserModel> splitUpNames = new ArrayList<>();
		splitUpNames.add(admin);
		//Using Java 8 Stream to print out each tuple fo the list
		splitUpNames.forEach(name->log.info(String.format("Inserting customer record for %s %s", splitUpNames.get(0).getLogin(), splitUpNames.get(0).getfName())));

		// Use Jdbc Template bach Update Operation to bulk load data
		List<Object[]> liste = new ArrayList<>();


		/*

		jdbcTemplate.batchUpdate("INSERT INTO user(login,password) VALUES (?,?)", splitUpNames,1,
				(ParameterizedPreparedStatementSetter<UserModel>) (ps, argument) -> {
					ps.setString(1, argument.getLogin());
					ps.setString(2, argument.getPassword());
				});*/
		// User implements User details interface
		//jdbcTemplate.

	}
}
