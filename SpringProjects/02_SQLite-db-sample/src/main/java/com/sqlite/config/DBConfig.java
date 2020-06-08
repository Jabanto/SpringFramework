package com.sqlite.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DBConfig {

	@Autowired
	Environment env;

	/**
	 * Since Spring Boot doesn't provide configuration support for SQLite database
	 * out of the box , we define the DataSource bean to conect to SQLlite.
	 * this we can use for oder DB that are not supported by spring boot
	 * @return dataSource with connection methods and we binding these to our property file with the use  of Environment
	 */
    @Bean
	public DataSource dataSource() {
	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
	        dataSourceBuilder.url("jdbc:sqlite:mydb.db");
	        dataSourceBuilder.username(env.getProperty("sqlite.user"));
	        dataSourceBuilder.password(env.getProperty("sqlite.password"));
	        return dataSourceBuilder.build();   
	}
}
