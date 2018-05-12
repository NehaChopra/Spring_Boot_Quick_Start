package com.scotch.io.RESTAndSwagger.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scotch.io.RESTAndSwagger.dto.UserProfile;
import com.scotch.io.RESTAndSwagger.interfaces.UserService;

/*
 * 
 * main] c.s.i.R.RestAndSwaggerApplication        : No active profile set, falling back to default profiles: default
 * 
 * 
 *  main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@6f01b95f: startup date [Sat May 12 17:16:13 IST 2018]; root of context hierarchy
2018-05-12 17:16:18.872  INFO 13387 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/users/add],methods=[POST]}" onto public com.scotch.io.RESTAndSwagger.dto.UserProfile com.scotch.io.RESTAndSwagger.controller.UserController.addUserDetails(com.scotch.io.RESTAndSwagger.dto.UserProfile) throws java.lang.Exception
2018-05-12 17:16:18.873  INFO 13387 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/users/fetchUsers],methods=[GET]}" onto public org.json.simple.JSONObject com.scotch.io.RESTAndSwagger.controller.UserController.getUsers() throws java.lang.Exception
2018-05-12 17:16:18.876  INFO 13387 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/users/addUser],methods=[POST]}" onto public org.json.simple.JSONObject com.scotch.io.RESTAndSwagger.controller.UserController.addUsers(com.scotch.io.RESTAndSwagger.dto.UserProfile) throws java.lang.Exception
2018-05-12 17:16:18.880  INFO 13387 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/users/updateUser],methods=[PATCH]}" onto public org.json.simple.JSONObject com.scotch.io.RESTAndSwagger.controller.UserController.updateUsers(com.scotch.io.RESTAndSwagger.dto.UserProfile) throws java.lang.Exception
2018-05-12 17:16:18.881  INFO 13387 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/users/deleteUser],methods=[DELETE]}" onto public org.json.simple.JSONObject com.scotch.io.RESTAndSwagger.controller.UserController.deleteUsers(com.scotch.io.RESTAndSwagger.dto.UserProfile) throws java.lang.Exception
2018-05-12 17:16:18.881  INFO 13387 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/users/delete],methods=[DELETE]}" onto public com.scotch.io.RESTAndSwagger.dto.UserProfile com.scotch.io.RESTAndSwagger.controller.UserController.deleteUserDetails(com.scotch.io.RESTAndSwagger.dto.UserProfile) throws java.lang.Exception
2018-05-12 17:16:18.882  INFO 13387 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/users/],methods=[GET]}" onto public com.scotch.io.RESTAndSwagger.dto.UserProfile com.scotch.io.RESTAndSwagger.controller.UserController.getUserDetails() throws java.lang.Exception
2018-05-12 17:16:18.885  INFO 13387 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/api/users/update],methods=[PATCH]}" onto public com.scotch.io.RESTAndSwagger.dto.UserProfile com.scotch.io.RESTAndSwagger.controller.UserController.updateUserDetails(com.scotch.io.RESTAndSwagger.dto.UserProfile) throws java.lang.Exception
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired(required=true)
	UserService userService;
	
	/*
	 * 
{
    "restStatus": "SUCCESS",
    "id": "23469384757585949487474",
    "firstName": "NEHA",
    "lastName": "CHOPRA",
    "mobileNumber": "+91-9876543210",
    "email": "neha.chopra@gmail.com",
    "registeredAddress": {
        "address": "INDIA",
        "countryName": "INDIA",
        "stateName": "INDIA",
        "cityName": "INDIA"
    }
}
	 */
	
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public UserProfile getUserDetails() throws Exception {
		LOGGER.info("Fetching User details RequestMethod.GET");
		UserProfile userProfile = null;
		try {
			userProfile = userService.getUserDetails();
		}catch(Exception e) {
			
		}
		return userProfile;
	}
	
	
	
	
	/*
	 * 
REQUEST :
{
    "restStatus": "SUCCESS",
    "id": "23469384757585949487474",
    "firstName": "KARAN",
    "lastName": "CHOPRA",
    "mobileNumber": "+91-9876543210",
    "email": "karan.chopra@gmail.com",
    "registeredAddress": {
        "address": "JAPAN",
        "countryName": "JAPAN",
        "stateName": "JAPAN",
        "cityName": "JAPAN"
    }
}
	
RESPONSE : 
{
    "restStatus": "SUCCESS",
    "id": "23469384757585949487474",
    "firstName": "KARAN",
    "lastName": "CHOPRA",
    "mobileNumber": "+91-9876543210",
    "email": "karan.chopra@gmail.com",
    "registeredAddress": {
        "address": "JAPAN",
        "countryName": "JAPAN",
        "stateName": "JAPAN",
        "cityName": "JAPAN"
    }
}
	 * 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public UserProfile addUserDetails(@RequestBody UserProfile userProfile) throws Exception {
		LOGGER.info("Fetching User details RequestMethod.POST");
		try {
			userProfile = userService.addUserDetails(userProfile);
		}catch(Exception e) {
			
		}
		return userProfile;
	}
	
	
	
	/*
	 * 
REQUEST :
{
    "restStatus": "SUCCESS",
    "id": "23469384757585949487474",
    "firstName": "KARAN",
    "lastName": "CHOPRA",
    "mobileNumber": "+91-9876543210",
    "email": "karan.chopra@gmail.com",
    "registeredAddress": {
        "address": "JAPAN",
        "countryName": "JAPAN",
        "stateName": "JAPAN",
        "cityName": "JAPAN"
    }
}
	
RESPONSE : 
{
    "restStatus": "SUCCESS",
    "id": "23469384757585949487474",
    "firstName": "KARAN",
    "lastName": "CHOPRA",
    "mobileNumber": "+91-9876543210",
    "email": "karan.chopra@gmail.com",
    "registeredAddress": {
        "address": "JAPAN",
        "countryName": "JAPAN",
        "stateName": "JAPAN",
        "cityName": "JAPAN"
    }
}
	 * 
	 */
	
	
	
	/*
	 * {
    "timestamp": 1526126248328,
    "status": 405,
    "error": "Method Not Allowed",
    "message": "Request method 'POST' not supported",
    "path": "/api/users/update"
	}
	
	WHEN wrong http verb used for request.
	 */
	
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public UserProfile updateUserDetails(@RequestBody UserProfile userProfile) throws Exception {
		LOGGER.info("Fetching User details RequestMethod.GET");
		try {
			userProfile = userService.updateUserDetails(userProfile);
		}catch(Exception e) {
			
		}
		return userProfile;
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public UserProfile deleteUserDetails(@RequestBody UserProfile userProfile) throws Exception {
		LOGGER.info("Fetching User details RequestMethod.GET");
		try {
			userProfile = userService.deleteUserDetails(userProfile);
		}catch(Exception e) {
			
		}
		return userProfile;
	}
	
	
	/*
	 * API to fetch the JSON document from txt file
	 */
	
	@RequestMapping(value = "/fetchUsers", method = RequestMethod.GET)
	public JSONObject getUsers() throws Exception {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/neha/testjson.txt"));

		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}
	
	@RequestMapping(value = "/addUsers", method = RequestMethod.POST)
	public JSONObject addUsers(@RequestBody UserProfile userProfile) throws Exception {
		/*
		 * Write to file and read the file
		 * Use JAVA 7 TRY with resource
		 */
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(userProfile);
		
		try(FileWriter file = new FileWriter("/home/neha/testjson.txt")){
			 file.write(json);
	         file.flush();
		}
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/neha/testjson.txt"));

		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
		
	}
	
	
	@RequestMapping(value = "/updateUsers", method = RequestMethod.PUT)
	public JSONObject updateUsers(@RequestBody UserProfile userProfile) throws Exception {
		/*
		 * Write to file and read the file
		 * Use JAVA 7 TRY with resource
		 */
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(userProfile);
		
		try(FileWriter file = new FileWriter("/home/neha/testjson.txt")){
			 file.write(json);
	         file.flush();
		}
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/neha/testjson.txt"));

		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}
	
	@RequestMapping(value = "/deleteUsers", method = RequestMethod.DELETE)
	public JSONObject deleteUsers(@RequestBody UserProfile userProfile) throws Exception {
		/*
		 * Write to file and read the file
		 * Use JAVA 7 TRY with resource
		 */
		
		try(FileWriter file = new FileWriter("/home/neha/testjson.txt")){
			 file.write("");
	         file.flush();
		}
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/neha/testjson.txt"));

		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}
}