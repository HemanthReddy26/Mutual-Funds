package com.hcl.user.dto;

public class Credentials {

	private String userName;

	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassWord(String password) {
		this.password = password;
	}

	public Credentials(String userName, String password) {

		this.userName = userName;
		this.password = password;
	}

	public Credentials() {

	}

}
