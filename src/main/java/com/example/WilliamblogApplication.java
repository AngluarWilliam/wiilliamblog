package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WilliamblogApplication {

	public static void main(String[] args) {
		SpringApplication.run(WilliamblogApplication.class, args);
		System.out.println("http://localhost:8080");
	}

}
