package com.ptechnologies.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ecom");
		dataSource.setUsername("root");
		dataSource.setPassword("spg11063");
		return new JdbcTemplate(dataSource);
	}

}
