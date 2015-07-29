package com.outsourcemib.homepagemib.model.persistence.dao;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.outsourcemib.homepagemib.model.persistence.entity.ShortMessage;

public class ShortMessageDAO {

	public ShortMessage persist(ShortMessage sms) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity entity = new Entity("ShortMessage", sms.getSender().getLoginKey());
		entity.setProperty("to", sms.getTo());
		entity.setProperty("from", sms.getFrom());
		entity.setProperty("body", sms.getBody());
		entity.setProperty("price", sms.getPrice());
		entity.setProperty("registered", sms.getRegistered());
		datastore.put(entity);
		sms.setShortMessageKey(entity.getKey());
		return sms;
	}
	
	public void delete(ShortMessage sms) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.delete(sms.getShortMessageKey());
	}

	public List<ShortMessage> list(ShortMessage sms) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("ShortMessage");
		
		if(sms!= null && sms.getSender() != null && sms.getSender().getLoginKey() != null){
			q.setAncestor(sms.getSender().getLoginKey());
		}
		
		q.addSort("registered", SortDirection.DESCENDING);

		
		PreparedQuery pq = datastore.prepare(q);

		List<ShortMessage> list = new LinkedList<ShortMessage>();
		for (Entity result : pq.asIterable()) {
			ShortMessage sm = new ShortMessage();
			sm.setShortMessageKey(result.getKey());
			sm.setFrom( (String) result.getProperty("from") );
			sm.setTo((String) result.getProperty("to")  );
			sm.setBody((String) result.getProperty("body")  );
			sm.setPrice((Double) result.getProperty("price")  );
			sm.setRegistered((Date) result.getProperty("registered")  );
			
			list.add(sm);
		}

		return list;
	}
}
