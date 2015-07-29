package com.outsourcemib.homepagemib.model.persistence.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

public class ShortMessage implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Key shortMessageKey;
	
	private String to;
	private String from;
	private String body;
	private double price;
	private Date registered = new Date();
	private String registeredFormated;
	private Login sender;
	
	public Key getShortMessageKey() {
		return shortMessageKey;
	}
	public void setShortMessageKey(Key shortMessageKey) {
		this.shortMessageKey = shortMessageKey;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Date getRegistered() {
		return registered;
	}
	public void setRegistered(Date registered) {
		this.registered = registered;
	}
	public Login getSender() {
		return sender;
	}
	public void setSender(Login sender) {
		this.sender = sender;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRegisteredFormated() {
		if(registered != null){
			return new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(registered);
		}else
			return registeredFormated;
	}
	public void setRegisteredFormated(String registeredFormated) {
		this.registeredFormated = registeredFormated;
	}
	
}