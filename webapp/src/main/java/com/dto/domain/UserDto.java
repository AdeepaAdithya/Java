package com.dto.domain;

public class UserDto {
	String userName;
	String password;
	/**
	 * @return the firstName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setUserName(String firstName) {
		this.userName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getPasswordName() {
		return password;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setPasswordName(String lastName) {
		password = lastName;
	}
	@Override
	public String toString() {
		return "UserDto [firstName=" + userName + ", LastName=" + password + "]";
	}
}
