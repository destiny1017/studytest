package com.example.studytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class StudytestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudytestApplication.class, args);
	}

}
