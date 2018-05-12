package com.scotch.io.RESTAndSwagger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;

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
	
	@Bean
	public MappingJackson2HttpMessageConverter jacksonConvertor() {
		MappingJackson2HttpMessageConverter convertor = new MappingJackson2HttpMessageConverter();
		convertor.getObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		convertor.getObjectMapper().setSerializationInclusion(Include.NON_NULL);
		return convertor;
	}
	
}
