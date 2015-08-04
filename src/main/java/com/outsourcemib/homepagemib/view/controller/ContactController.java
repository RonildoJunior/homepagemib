package com.outsourcemib.homepagemib.view.controller;

import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.outsourcemib.homepagemib.ConstantsOfSystem;
import com.outsourcemib.homepagemib.model.persistence.entity.Contact;
import com.outsourcemib.homepagemib.model.persistence.entity.Login;
import com.outsourcemib.homepagemib.model.service.ContactService;

@Controller
public class ContactController {

	private static final Logger log = Logger.getLogger(ContactController.class.getName());
	private ContactService contactService = new ContactService();
	
	@RequestMapping(value="listContact", method=RequestMethod.GET)
	public String listContact(Map<String, Object> map, HttpSession session){
		log.info("listContact");
		
		Login login = (Login)session.getAttribute(ConstantsOfSystem.USER_SESSION_KEY);
		Contact contact = new Contact(login);
		map.put("contactList", contactService.list(contact) );
		
		return "contact/contactList";
	}

}
