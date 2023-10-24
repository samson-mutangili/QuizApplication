package com.samson.quizapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizAppApplication.class, args);
		System.out.println("Started Quiz Application.");
		System.out.println("Status: Running...");
	}

}
