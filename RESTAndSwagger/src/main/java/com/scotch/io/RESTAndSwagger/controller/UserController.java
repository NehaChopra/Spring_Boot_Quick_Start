package com.scotch.io.RESTAndSwagger.controller;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scotch.io.RESTAndSwagger.dto.UserProfile;
import com.scotch.io.RESTAndSwagger.interfaces.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired(required=true)
	UserService userService;
	
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
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public UserProfile addUserDetails(@RequestBody UserProfile userProfile) throws Exception {
		LOGGER.info("Fetching User details RequestMethod.GET");
		try {
			userProfile = userService.addUserDetails(userProfile);
		}catch(Exception e) {
			
		}
		return userProfile;
	}
	
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
		Object obj = parser.parse(new FileReader("/home/nehachopra/Desktop/testjson.txt"));

		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public JSONObject addUsers(@RequestBody UserProfile userProfile) throws Exception {
		/*
		 * Write to file and read the file
		 */
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/nehachopra/Desktop/testjson.txt"));

		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}
	
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.PATCH)
	public JSONObject updateUsers(@RequestBody UserProfile userProfile) throws Exception {
		/*
		 * Write to file and read the file
		 */
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/nehachopra/Desktop/testjson.txt"));

		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
	public JSONObject deleteUsers(@RequestBody UserProfile userProfile) throws Exception {
		/*
		 * Write to file and read the file
		 */
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("/home/nehachopra/Desktop/testjson.txt"));

		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject;
	}
}