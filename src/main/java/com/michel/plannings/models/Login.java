package com.michel.plannings.models;


public class Login {
	
	private String user;
	private String password;
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Login(String user, String password) {
		super();
		this.user = user;
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
