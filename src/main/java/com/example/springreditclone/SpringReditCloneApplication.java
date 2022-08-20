package com.example.springreditclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringReditCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReditCloneApplication.class, args);
	}

}
