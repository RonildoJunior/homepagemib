package com.outsourcemib.homepagemib.model.service;

import com.outsourcemib.homepagemib.model.persistence.dao.AccountDAO;
import com.outsourcemib.homepagemib.model.persistence.entity.Account;
import com.outsourcemib.homepagemib.model.persistence.entity.Login;

public class AccountService {
	
	private AccountDAO accountDAO = new AccountDAO();

	public Account put(Account arg) {
		return accountDAO.put(arg);
	}
	
	public Account findLoginAccount(Login login){
		Account account = new Account();
		account.setOwner(login);
		return accountDAO.get(account);
	}


}
