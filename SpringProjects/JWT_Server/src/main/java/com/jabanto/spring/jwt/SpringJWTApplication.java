package com.jabanto.spring.jwt;

import com.jabanto.spring.jwt.Repository.RoleUserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    private RoleUserRepo userRepo;

	@Value("sql.import")
	private String importSql;

	@Override
	public void run(String... args) throws Exception {

		if (importSql.equalsIgnoreCase("TRUE")) {
			mainlog.info("Connecting to Mysql DB and creating basic DataSet records");
			userRepo.insertDataSet();
		}
	}
}
