package com.shelke.sachin.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(String[] args) { //From Sp. Boot Framework - executed after spring beans are loaded
		return runner -> {
			System.out.println("Hello Sachin B Shelke!!");
		};
	}
}
