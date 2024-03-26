package com.snipe.let.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.snipe.let.admin")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class LetApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetApplication.class, args);
		System.out.println("<---------------------BOOOOOOOOOOOOTED--------------------------->");
	}

}
