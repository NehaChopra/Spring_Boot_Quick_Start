package com.scotch.io.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EhcacheApplication {

	/*
	 * Ehcache, a widely used, open-source Java-based cache.
	 * It features memory and disk stores, listeners, cache loaders, RESTful and SOAP APIs and other very useful features.
	 * To show how caching can optimize our application,we will create a simple method which will calculate square values of provided numbers. 
	 * On each call, the method will call calculateSquareOfNumber(int number) method and print information message to the console.
	 * With this simple example, we want to show that calculation of squared values is done only once, and every other call with same input value is 
	 * returning result from cache.
	 * 
	 */
	
	public static void main(String[] args) {
		SpringApplication.run(EhcacheApplication.class, args);
	}
}
