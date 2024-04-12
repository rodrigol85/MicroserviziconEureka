package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicroserviceConfigServiceExercise1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigServiceExercise1Application.class, args);
	}

}
