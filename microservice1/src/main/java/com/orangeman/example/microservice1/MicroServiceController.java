package com.orangeman.example.microservice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@RestController
public class MicroServiceController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@GetMapping("/microservice1")
	public String method1() {
		logger.info("Inside method 1");
		String baseUrl = "http://localhost:8081/microservice2";
		String response = restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
		logger.info("The response recived by method1 is " + response);
		return response;
	}
	
}
