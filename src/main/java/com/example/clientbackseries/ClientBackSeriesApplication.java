package com.example.clientbackseries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientBackSeriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientBackSeriesApplication.class, args);
	}

}
