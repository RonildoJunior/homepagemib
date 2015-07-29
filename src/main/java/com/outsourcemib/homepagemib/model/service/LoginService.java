package com.outsourcemib.homepagemib.model.service;

import java.util.List;

import com.google.appengine.api.datastore.KeyFactory;
import com.outsourcemib.homepagemib.model.persistence.dao.AccountDAO;
import com.outsourcemib.homepagemib.model.persistence.dao.LoginDAO;
import com.outsourcemib.homepagemib.model.persistence.entity.Account;
import com.outsourcemib.homepagemib.model.persistence.entity.Login;

public class LoginService {
	
	private LoginDAO loginDAO = new LoginDAO();
	private AccountDAO accountDAO = new AccountDAO();

	public Login put(Login arg) {
		return loginDAO.put(arg);
	}
	
	public Login signup(Login arg){
		Login entityLogin = loginDAO.put(arg);
		
		Account account  = new Account();
		account.setBalance(1);
		account.setOwner(arg);
		accountDAO.put(account);
		
		return entityLogin;
	}
	
	public Login get(String id){
		Login login = new Login();
		login.setLoginKey(KeyFactory.createKey("Login", id) );
		return loginDAO.get(login);
	}
	
	public Login delete(Login arg) {
		return new LoginDAO().delete(arg);
	}
	
	public List<Login> listAll() {
		return new LoginDAO().list(null);
	}
}