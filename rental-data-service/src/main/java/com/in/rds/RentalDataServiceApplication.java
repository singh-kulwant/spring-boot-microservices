package com.in.rds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.in.common.model")
@ComponentScan(basePackages = "com.in.rds.repository")
public class RentalDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentalDataServiceApplication.class, args);
	}

}
