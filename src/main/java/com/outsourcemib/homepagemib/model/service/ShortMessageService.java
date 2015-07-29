package com.outsourcemib.homepagemib.model.service;

import java.util.List;

import com.outsourcemib.homepagemib.HomePageConfiguration;
import com.outsourcemib.homepagemib.model.persistence.dao.ContactDAO;
import com.outsourcemib.homepagemib.model.persistence.dao.ShortMessageDAO;
import com.outsourcemib.homepagemib.model.persistence.entity.Account;
import com.outsourcemib.homepagemib.model.persistence.entity.Contact;
import com.outsourcemib.homepagemib.model.persistence.entity.Login;
import com.outsourcemib.homepagemib.model.persistence.entity.ShortMessage;
import com.outsourcemib.homepagemib.sms.SMSPushPool;

public class ShortMessageService {
	
	private ShortMessageDAO shortMessageDAO = new ShortMessageDAO();
	private ContactDAO contactDAO = new ContactDAO();
	private AccountService accountService = new AccountService();
	private SMSPushPool smsPushPool = new SMSPushPool();
	
	public ShortMessage persist(ShortMessage shortMessage) {
		
		ShortMessage entity = null;
		Account account = accountService.findLoginAccount(shortMessage.getSender());
		
		Contact contact = new Contact(shortMessage.getTo());
		contact.setOwner(shortMessage.getSender());
		contactDAO.persist(contact);
		
		if( (account.getBalance() - HomePageConfiguration.SMS_PRICE ) >= 0){
			shortMessage.setFrom(HomePageConfiguration.SMS_FROM);
			shortMessage.setPrice(HomePageConfiguration.SMS_PRICE);
			entity = shortMessageDAO.persist(shortMessage);
			smsPushPool.send(shortMessage.getBody(), shortMessage.getTo(), shortMessage.getFrom());
			account.setBalance( account.getBalance() - HomePageConfiguration.SMS_PRICE );
			accountService.put(account);
		}
		
		return entity;
	}
	
	public List<ShortMessage> list(Login login){
		ShortMessage sms = new ShortMessage();
		sms.setSender(login);
		return shortMessageDAO.list(sms);
	}
}
