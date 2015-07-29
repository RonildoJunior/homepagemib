package com.outsourcemib.homepagemib.model.service;

import com.google.appengine.api.datastore.EntityNotFoundException;

public class ServiceException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ServiceException(){
	}
	public ServiceException(EntityNotFoundException ex){
		super(ex);
	}
}
