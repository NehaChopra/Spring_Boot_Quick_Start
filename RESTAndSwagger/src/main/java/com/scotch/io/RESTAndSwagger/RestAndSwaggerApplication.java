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


/*
 * Consuming a RESTful Web Service
 * RestTemplate makes interacting with most RESTful services a one-line incantation. 
 * And it can even bind that data to custom domain types.RestTemplate makes interacting with most 
 * RESTful services a one-line incantation. And it can even bind that data to custom domain types.
 * 
 * 
 * 
 * As you can see, this is a simple Java class with a handful of properties and matching getter methods. 
 * It’s annotated with @JsonIgnoreProperties from the Jackson JSON processing library to indicate that any 
 * properties not bound in this type should be ignored.
 * 
 * 
 * 
 * 
 * In order for you to directly bind your data to your custom types, you need to specify the variable 
 * name exact same as the key in the JSON Document returned from the API. In case your variable name 
 * and key in JSON doc are not matching, you need to use @JsonProperty annotation to specify the exact key of JSON document.
 * 
 * 
 * 
 * Because the Jackson JSON processing library is in the classpath,
 *  RestTemplate will use it (via a message converter) to convert the incoming JSON data into a Quote object.
 *   From there, the contents of the Quote object will be logged to the console.
 */
@SpringBootApplication
public class RestAndSwaggerApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(RestAndSwaggerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestAndSwaggerApplication.class, args);
	}
	
	/*
	 * The RestTemplateBuilder is injected by Spring, and if you use it to create a 
	 * RestTemplate then you will benefit from all the autoconfiguration that happens 
	 * in Spring Boot with message converters and request factories. We also extract 
	 * the RestTemplate into a @Bean to make it easier to test (it can be mocked more easily that way).
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	
	/*
	 * https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/http/converter/HttpMessageConverter.html
	 */
	@Bean
	public MappingJackson2HttpMessageConverter jacksonConvertor() {
		MappingJackson2HttpMessageConverter convertor = new MappingJackson2HttpMessageConverter();
		convertor.getObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		convertor.getObjectMapper().setSerializationInclusion(Include.NON_NULL);
		return convertor;
	}
	
}
