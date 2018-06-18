package com.scotch.io.POJOKafkaProducerConsumer.dto;

public class User {
	private String firstName;
	private String middleName;
	private String lastName;
	private String displayName;
	private String mName;
	private String mobile;
	private String email;
	
	public User() {}
	
	public User(String firstName, String middleName, String lastName, String displayName, String mName, String mobile, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.displayName = displayName;
		this.mName = mName;
		this.mobile = mobile;
		this.middleName = middleName;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName 
				+ ", displayName=" + displayName + ", mName=" + mName + ", mobile=" + mobile + ", email="
				+ email +  "]";
	}
}
