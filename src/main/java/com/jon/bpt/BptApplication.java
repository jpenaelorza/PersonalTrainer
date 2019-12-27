package com.jon.bpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // Con este exclude desactivamos el login por
																		// defecto
public class BptApplication {

	public static void main(String[] args) {
		SpringApplication.run(BptApplication.class, args);
	}

}
