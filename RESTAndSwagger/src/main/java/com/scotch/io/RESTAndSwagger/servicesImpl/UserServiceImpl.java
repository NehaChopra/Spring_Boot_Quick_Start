package com.scotch.io.RESTAndSwagger.servicesImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.scotch.io.RESTAndSwagger.dto.UserProfile;
import com.scotch.io.RESTAndSwagger.interfaces.UserService;
import com.scotch.io.RESTAndSwagger.util.ApiHelper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	ApiHelper apiHelper;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public UserProfile getUserDetails() throws Exception {
		LOGGER.info("Inside getUserDetails for mid :{}");
		
		UserProfile userProfile = null;
		try {
			userProfile = apiHelper.getUserDetails();
			if(userProfile!=null && StringUtils.pathEquals(userProfile.getRestStatus(), "SUCCESS")) {
				return userProfile;
			}else {
				
			}
		}catch(Exception e) {
			
		}
		return userProfile;
	}

	@Override
	public UserProfile addUserDetails(UserProfile userProfile) throws Exception {
		LOGGER.info("Inside getUserDetails for mid :{}");
		
		try {
			userProfile = apiHelper.addUserDetails(userProfile);
			if(userProfile!=null && StringUtils.pathEquals(userProfile.getRestStatus(), "SUCCESS")) {
				return userProfile;
			}else {
				
			}
		}catch(Exception e) {
			
		}
		return userProfile;
	}

	@Override
	public UserProfile updateUserDetails(UserProfile userProfile) throws Exception {
		LOGGER.info("Inside getUserDetails for mid :{}");
		
		try {
			userProfile = apiHelper.updateUserDetails(userProfile);
			if(userProfile!=null && StringUtils.pathEquals(userProfile.getRestStatus(), "SUCCESS")) {
				return userProfile;
			}else {
				
			}
		}catch(Exception e) {
			
		}
		return userProfile;
	}

	@Override
	public UserProfile deleteUserDetails(UserProfile userProfile) throws Exception {
		LOGGER.info("Inside getUserDetails for mid :{}");
		
		try {
			userProfile = apiHelper.deleteUserDetails(userProfile);
			if(userProfile!=null && StringUtils.pathEquals(userProfile.getRestStatus(), "SUCCESS")) {
				return userProfile;
			}else {
				
			}
		}catch(Exception e) {
			
		}
		return userProfile;
	}
	
}