package com.app.entities;

public class Users {
	private String loginId;
	private String pass;
	private int type;
	
	public Users(int type)
	{
		this.type=type;
	}
	
	public Users(String loginId, String pass, int type) {
		super();
		this.loginId = loginId;
		this.pass = pass;
		this.type = type;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
	
}
