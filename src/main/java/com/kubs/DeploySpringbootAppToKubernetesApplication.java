package com.kubs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DeploySpringbootAppToKubernetesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeploySpringbootAppToKubernetesApplication.class, args);
		System.out.println("App is runniung!!!");
	}

	@GetMapping("/message")
	public String displayMessage(){
		return ("This is a new message from springboot app!!!!");
	}
}
