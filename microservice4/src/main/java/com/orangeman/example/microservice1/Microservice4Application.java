package com.orangeman.example.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
public class Microservice4Application {


	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Microservice4Application.class, args);
	}

}
