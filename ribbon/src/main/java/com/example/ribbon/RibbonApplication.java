package com.example.ribbon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Value("${server.port}")
	String port;
/*
	@Value("${server.application.name}")
	String serviceName;*/

	@GetMapping("/")
	public String index() {
		return getRestTemplate().getForObject("http://eureka-client/", String.class);
	}
}
