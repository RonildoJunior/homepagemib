package com.outsourcemib.homepagemib.model.persistence.entity;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Key accountKey;
	private double balance;
	private Login owner;
	
	public Account(){}
	public Account(Login login){
		this.owner = login;
	}
	
	public Key getAccountKey() {
		return accountKey;
	}
	public void setAccountKey(Key accountKey) {
		this.accountKey = accountKey;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Login getOwner() {
		return owner;
	}
	public void setOwner(Login owner) {
		this.owner = owner;
	}
}
