package com.jabanto.spring.SpringMVc;

import com.jabanto.spring.SpringMVc.Repository.RoleUserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJWTApplication implements CommandLineRunner {

	private static final Logger mainlog = LoggerFactory.getLogger(SpringJWTApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJWTApplication.class, args);
	}

	@Autowired
    RoleUserRepo userRepo;

	@Override
	public void run(String... args) throws Exception {

		mainlog.info("Connecting to Mysql DB");
		//userRepo.insertDataSet();
	}
}
