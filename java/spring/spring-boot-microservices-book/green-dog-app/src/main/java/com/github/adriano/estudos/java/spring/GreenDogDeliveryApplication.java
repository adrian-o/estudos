package com.github.adriano.estudos.java.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.github")
public class GreenDogDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenDogDeliveryApplication.class, args);
	}
} 
