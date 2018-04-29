package com.scotch.io.RESTAndSwagger.interfaces;

import com.scotch.io.RESTAndSwagger.dto.UserProfile;

public interface UserService {
	
	public UserProfile getUserDetails() throws Exception;
	
	public UserProfile addUserDetails(UserProfile userProfile) throws Exception;
	
	public UserProfile updateUserDetails(UserProfile userProfile) throws Exception;
	
	public UserProfile deleteUserDetails(UserProfile userProfile) throws Exception;
	
}