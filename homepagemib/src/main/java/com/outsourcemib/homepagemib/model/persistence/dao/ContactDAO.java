package com.outsourcemib.homepagemib.model.persistence.dao;

import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.outsourcemib.homepagemib.model.persistence.entity.Contact;

public class ContactDAO {

	public Contact persist(Contact contact) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity entity = new Entity("Contact", contact.getOwner().getLoginKey());
		entity.setProperty("name", contact.getName());
		entity.setProperty("phone", contact.getPhone());
		datastore.put(entity);
		contact.setContactKey(entity.getKey());
		return contact;
	}
	
	public Contact get(Contact contact){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Contact");
		
		if(contact!= null && contact.getOwner() != null && contact.getOwner().getLoginKey() != null){
			q.setAncestor(contact.getOwner().getLoginKey());
		}
		
		if(contact.getPhone() != null && !contact.getPhone().trim().equals("")){
			Filter phone = new FilterPredicate("phone", FilterOperator.EQUAL, contact.getPhone().trim());
			q.setFilter(phone);
		}
		
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			Contact entity = new Contact();
			entity.setContactKey(result.getKey());
			entity.setName( (String) result.getProperty("name") );
			entity.setPhone((String) result.getProperty("phone")  );
			
			return contact;
		}
		return null;
	}
	
	public List<Contact> list(Contact contact) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Contact");
		
		if(contact!= null && contact.getOwner() != null && contact.getOwner().getLoginKey() != null){
			q.setAncestor(contact.getOwner().getLoginKey());
		}
		
		q.addSort("name", SortDirection.ASCENDING);

		
		PreparedQuery pq = datastore.prepare(q);

		List<Contact> list = new LinkedList<Contact>();
		for (Entity result : pq.asIterable()) {
			Contact entity = new Contact();
			entity.setContactKey(result.getKey());
			entity.setName( (String) result.getProperty("name") );
			entity.setPhone((String) result.getProperty("phone")  );
			
			list.add(entity);
		}

		return list;
	}
}
