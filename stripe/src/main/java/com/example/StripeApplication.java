package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StripeApplication {

	public static void main(String[] args) {
		SpringApplication.run(StripeApplication.class, args);
		System.out.println("ok");
	}

}