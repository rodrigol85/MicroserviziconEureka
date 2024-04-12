package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceEmployeeServiceA1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEmployeeServiceA1Application.class, args);
	}

}
