package com.scotch.io.RESTAndSwagger.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scotch.io.RESTAndSwagger.dto.UserProfile;

@Component
public class ApiHelper{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiHelper.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Value("${base.url}")
	private String baseUrl;
	
	@Value("${getUserApiEndPoint.url}")
	private String getUserApiEndPoint;
	
	@Value("${addUserApiEndPoint.url}")
	private String addUserApiEndPoint;
	
	@Value("${updateUserApiEndPoint.url}")
	private String updateUserApiEndPoint;
	
	@Value("${deleteUserApiEndPoint.url}")
	private String deleteUserApiEndPoint;
	
	public UserProfile getUserDetails() {
		UserProfile resp = null;
		try {
			long startTime = System.currentTimeMillis();
			LOGGER.info("Request goes on searchRequest-Body: {}");
			
			resp= restTemplate.getForObject(baseUrl + getUserApiEndPoint, UserProfile.class);
			long endTime = System.currentTimeMillis();
			
			LOGGER.info("User details API response Time: {}", (endTime - startTime));

		} catch (Exception ex) {
			LOGGER.error("Exception occurred while fetching merchant acquiring details. Exception :{}", ex);
		}
		return resp;
	}
	
	public UserProfile addUserDetails(UserProfile userProfile) {
		ResponseEntity<UserProfile> resp = null;
		try {
			String bodyParam = mapper.writeValueAsString(userProfile);
			long startTime = System.currentTimeMillis();
			LOGGER.info("Request goes on WITH Body: {} and url : {}", bodyParam, baseUrl + addUserApiEndPoint);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> httpReq = new HttpEntity<String>(bodyParam,headers);

			
			resp= restTemplate.exchange(baseUrl + addUserApiEndPoint, HttpMethod.POST, httpReq, UserProfile.class);
			long endTime = System.currentTimeMillis();
			
			LOGGER.info("User details API response Time: {}", (endTime - startTime));

		} catch (Exception ex) {
			LOGGER.error("Exception occurred while fetching merchant acquiring details. Exception :{}", ex);
		}
		return resp.getBody();
	}
	
	public UserProfile updateUserDetails(UserProfile userProfile) {
		ResponseEntity<UserProfile> resp = null;
		try {
			String bodyParam = mapper.writeValueAsString(userProfile);
			long startTime = System.currentTimeMillis();
			LOGGER.info("Request goes on searchRequest-Body: {}", bodyParam);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> httpReq = new HttpEntity<String>(bodyParam,headers);

			
			resp= restTemplate.exchange(baseUrl + updateUserApiEndPoint, HttpMethod.PUT, httpReq, UserProfile.class);
			long endTime = System.currentTimeMillis();
			
			LOGGER.info("User details API response Time: {}", (endTime - startTime));

		} catch (Exception ex) {
			LOGGER.error("Exception occurred while fetching merchant acquiring details. Exception :{}", ex);
		}
		return resp.getBody();
	}
	
	public UserProfile deleteUserDetails(UserProfile userProfile) {
		ResponseEntity<UserProfile> resp = null;
		try {
			String bodyParam = mapper.writeValueAsString(userProfile);
			long startTime = System.currentTimeMillis();
			LOGGER.info("Request goes on searchRequest-Body: {}", bodyParam);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> httpReq = new HttpEntity<String>(bodyParam,headers);

			
			resp= restTemplate.exchange(baseUrl + deleteUserApiEndPoint, HttpMethod.DELETE, httpReq, UserProfile.class);
			long endTime = System.currentTimeMillis();
			
			LOGGER.info("User details API response Time: {}", (endTime - startTime));

		} catch (Exception ex) {
			LOGGER.error("Exception occurred while fetching merchant acquiring details. Exception :{}", ex);
		}
		return resp.getBody();
	}
}