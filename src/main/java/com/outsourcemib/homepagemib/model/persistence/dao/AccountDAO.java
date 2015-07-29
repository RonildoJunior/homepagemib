package com.outsourcemib.homepagemib.model.persistence.dao;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.outsourcemib.homepagemib.model.persistence.entity.Account;

public class AccountDAO {
	
	public Account put(Account account){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity entity = new Entity("Account", account.getOwner().getEmail() ,account.getOwner().getLoginKey());
		entity.setProperty("balance", account.getBalance());
		datastore.put(entity);
		account.setAccountKey(entity.getKey());
		return account;
	}
	
	public Account get(Account arg){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Account");
		
		if(arg!= null && arg.getOwner() != null && arg.getOwner().getLoginKey() != null){
			q.setAncestor(arg.getOwner().getLoginKey());
		}
		
		PreparedQuery pq = datastore.prepare(q);
		
		for (Entity entity : pq.asIterable()) {
			Account account = new Account();
			account.setAccountKey(entity.getKey());
			account.setBalance( entity.getProperty("balance") == null ? 0 : (Double)entity.getProperty("balance"));
			account.setOwner(arg.getOwner());
			return account;
		}
		return null;
	}


}
