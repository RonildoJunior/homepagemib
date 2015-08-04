package com.outsourcemib.homepagemib.model.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

public class Login implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Key loginKey;
	private String name;
	private String email;
	private String password;
	private String phone;
	private Date registered = new Date();
	
	public Key getLoginKey() {
		return loginKey;
	}
	public void setLoginKey(Key loginKey) {
		this.loginKey = loginKey;
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
	public Date getRegistered() {
		return registered;
	}
	public void setRegistered(Date registered) {
		this.registered = registered;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
