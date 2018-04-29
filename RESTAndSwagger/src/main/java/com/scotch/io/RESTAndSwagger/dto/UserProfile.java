package com.scotch.io.RESTAndSwagger.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfile {
	private String restStatus;
	private String id;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String email;
	private UserAddressDetails registeredAddress;
	
	public String getRestStatus() {
		return restStatus;
	}
	public void setRestStatus(String restStatus) {
		this.restStatus = restStatus;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserAddressDetails getRegisteredAddress() {
		return registeredAddress;
	}
	public void setRegisteredAddress(UserAddressDetails registeredAddress) {
		this.registeredAddress = registeredAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "MerchantBasicDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", registeredAddress=" + registeredAddress + "]";
	}
	
}
