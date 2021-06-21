package com.churkin.dyplom.entity;

public class Account {
	private int id;
	
	private String email;
	
	private String password;
	
	private String tableName;
	
	public Account() { }
	
	public Account(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Account(int id, String email, String password, String tableName) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.tableName = tableName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + ", tableName=" + tableName + "]";
	}
	
	
}
