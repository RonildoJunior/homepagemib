package com.outsourcemib.homepagemib.model.persistence.entity;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

public class Contact implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Key contactKey;
	private String name;
	private String phone;
	private Login owner;
	
	public Contact(){}
	public Contact(String phone){
		this.phone = phone;
	}
	public Contact(Login owner){
		this.owner = owner;
	}
	
	public Key getContactKey() {
		return contactKey;
	}
	public void setContactKey(Key contactKey) {
		this.contactKey = contactKey;
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
	public Login getOwner() {
		return owner;
	}
	public void setOwner(Login owner) {
		this.owner = owner;
	}
}
