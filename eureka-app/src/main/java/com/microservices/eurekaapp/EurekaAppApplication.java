package com.microservices.eurekaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaAppApplication.class, args);
	}

}
