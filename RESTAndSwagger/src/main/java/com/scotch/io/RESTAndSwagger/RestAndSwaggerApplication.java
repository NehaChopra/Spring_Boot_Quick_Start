package com.scotch.io.RESTAndSwagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestAndSwaggerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestAndSwaggerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestAndSwaggerApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
