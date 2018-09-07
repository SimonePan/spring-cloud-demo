package com.example.eurekaclient2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient2Application.class, args);
	}

	@Value("${server.port}")
	String port;

	/*@Value("${server.application.name}")
	String serviceName;*/

	/*@GetMapping("/")
	public String getUser() {
		System.out.println("serviceName=" + serviceName + "; port=" + port);
		return "serviceName=" + serviceName + "; port=" + port;
	}*/

	@GetMapping("/")
	public String getUser() {
		System.out.println("port=" + port);
		return "port=" + port;
	}
}
