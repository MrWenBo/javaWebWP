package com.helloSQL.test;

public class User {
	private int id;
	private String userName;
	private String corp;
	
	public User(Integer id, String userName, String corp) {
		this.corp=corp;
		this.id=id;
		this.userName=userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCorp() {
		return corp;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}
	
}
