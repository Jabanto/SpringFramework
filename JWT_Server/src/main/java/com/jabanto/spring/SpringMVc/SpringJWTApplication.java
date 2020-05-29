package com.jabanto.spring.SpringMVc;

import com.jabanto.spring.SpringMVc.Model.UserModel;
import com.jabanto.spring.SpringMVc.Repository.UserRepo;
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

	private static final Logger mainlog = LoggerFactory.getLogger(SpringJWTApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJWTApplication.class, args);
	}

	@Autowired
	UserRepo userRepo;

	@Override
	public void run(String... args) throws Exception {

		mainlog.info("Conecting to Mysql DB");
		//userRepo.insertDataSet();
	}
}
