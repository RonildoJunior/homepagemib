package com.outsourcemib.homepagemib.view.controller;

import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.outsourcemib.homepagemib.ConstantsOfSystem;
import com.outsourcemib.homepagemib.model.persistence.entity.Login;
import com.outsourcemib.homepagemib.model.persistence.entity.ShortMessage;
import com.outsourcemib.homepagemib.model.service.ShortMessageService;

@Controller
public class ShortMessageController {
	
	private static final Logger log = Logger.getLogger(ShortMessageController.class.getName());
	private ShortMessageService shortMessageService = new ShortMessageService();
	
	@ResponseBody
	@RequestMapping(value="/persistShortMessage", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ShortMessage persistShortMessage(@RequestBody ShortMessage shortMessage, HttpSession session) {
		log.info("persistShortMessage");
		
		Login login = (Login)session.getAttribute(ConstantsOfSystem.USER_SESSION_KEY);
		shortMessage.setSender(login);
		
		shortMessageService.persist(shortMessage);
		return shortMessage;
    }
	
	@RequestMapping(value="listShortMessage", method=RequestMethod.GET)
	public String listShortMessage(Map<String, Object> map, HttpSession session){
		log.info("listShortMessage");
		
		Login login = (Login)session.getAttribute(ConstantsOfSystem.USER_SESSION_KEY);
		map.put("shortMessageList", shortMessageService.list(login) );
		
		return "sms/shortMessageList";
	}

}
