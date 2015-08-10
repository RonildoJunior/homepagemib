package com.outsourcemib.homepagemib.model.persistence.dao;

import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.outsourcemib.homepagemib.model.persistence.entity.Login;

public class LoginDAO {
	
	public Login put(Login login){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity entity = new Entity("Login", login.getEmail());
		entity.setProperty("name", login.getName());
		entity.setProperty("email", login.getEmail());
		entity.setProperty("password", login.getPassword());
		entity.setProperty("phone", login.getPhone());
		datastore.put(entity);
		login.setLoginKey(entity.getKey());
		return login;
	}
	
	public Login get(Login login){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		try{
			Entity entity = datastore.get(login.getLoginKey());
			login.setLoginKey(entity.getKey());
			login.setName( entity.getProperty("name") == null ? null : (String)entity.getProperty("name"));
			login.setEmail( entity.getProperty("email") == null ? null : (String)entity.getProperty("email"));
			login.setPassword( entity.getProperty("password") == null ? null : (String)entity.getProperty("password"));
			login.setPhone( entity.getProperty("phone") == null ? null : (String)entity.getProperty("phone"));
			return login;
		}catch(EntityNotFoundException ex){
			ex.printStackTrace();
			return null;
		}
	}
	
	public Login delete(Login login){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.delete(login.getLoginKey());
		return login;
	}

	public List<Login> list(Login arg){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Login");
		PreparedQuery pq = datastore.prepare(q);
		
		List<Login> list = new LinkedList<Login>();
		for (Entity entity : pq.asIterable()) {
			Login login = new Login();
			login.setLoginKey(entity.getKey());
			login.setName( entity.getProperty("name") == null ? null : (String)entity.getProperty("name"));
			login.setEmail( entity.getProperty("email") == null ? null : (String)entity.getProperty("email"));
			login.setPassword( entity.getProperty("password") == null ? null : (String)entity.getProperty("password"));
			login.setPhone( entity.getProperty("phone") == null ? null : (String)entity.getProperty("phone"));
			
			list.add(login);
		}
		return list;
	}
}
