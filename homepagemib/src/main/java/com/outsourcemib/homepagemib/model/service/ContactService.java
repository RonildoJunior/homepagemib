package com.outsourcemib.homepagemib.model.service;

import java.util.List;

import com.outsourcemib.homepagemib.model.persistence.dao.ContactDAO;
import com.outsourcemib.homepagemib.model.persistence.entity.Contact;

public class ContactService {
	
	private ContactDAO contactDAO = new ContactDAO();
	
	public Contact persist(Contact contact){
		return contactDAO.persist(contact);
	}
	
	public Contact find(Contact contact){
		return contactDAO.get(contact);
	}
	
	public List<Contact> list(Contact contact){
		return contactDAO.list(contact);
	}
}
