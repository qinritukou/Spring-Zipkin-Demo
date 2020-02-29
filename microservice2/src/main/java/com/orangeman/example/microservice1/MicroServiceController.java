package com.orangeman.example.microservice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MicroServiceController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@GetMapping("/microservice2")
	public String method2() {
		logger.info("Inside method 2");
		String baseUrl = "http://localhost:8082/microservice3";
		String response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		logger.info("The response recived by method2 is " + response);
		return response;
	}
	
}
