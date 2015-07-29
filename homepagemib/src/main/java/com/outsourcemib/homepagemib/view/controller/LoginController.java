package com.outsourcemib.homepagemib.view.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.outsourcemib.homepagemib.ConstantsOfSystem;
import com.outsourcemib.homepagemib.model.persistence.entity.Account;
import com.outsourcemib.homepagemib.model.persistence.entity.Login;
import com.outsourcemib.homepagemib.model.service.AccountService;
import com.outsourcemib.homepagemib.model.service.LoginService;

@Controller
public class LoginController {

	private static final Logger log = Logger.getLogger(LoginController.class.getName());
	private LoginService loginService = new LoginService();
	private AccountService accountService = new AccountService();

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/signin", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String signin(@RequestBody Login login, HttpSession session) {
		log.info("signin: " + login.getEmail());
		Login entityLogin = loginService.get(login.getEmail());
		Account entityAccount = accountService.findLoginAccount(entityLogin);
		
		session.setAttribute(ConstantsOfSystem.USER_SESSION_KEY, entityLogin);
		session.setAttribute(ConstantsOfSystem.USER_ACCOUNT_SESSION_KEY, entityAccount);
		if(entityLogin != null && login.getPassword().equals(entityLogin.getPassword())){
			JSONObject json = new JSONObject();
			json.put("message", "success");
			return json.toJSONString();
		}else{
			JSONObject json = new JSONObject();
			json.put("message",  "Incorrect password. \nPlease try again");
			return json.toJSONString();
		}
		
    }
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value="/signup", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody Login login, HttpSession session) {
		log.info("signup: " + login.getEmail());
		
		Login entityLogin = loginService.get(login.getEmail());
		if(entityLogin == null){
			entityLogin = loginService.signup(login);
			Account entityAccount = accountService.findLoginAccount(entityLogin);
			session.setAttribute(ConstantsOfSystem.USER_SESSION_KEY, entityLogin);
			session.setAttribute(ConstantsOfSystem.USER_ACCOUNT_SESSION_KEY, entityAccount);
			
			JSONObject json = new JSONObject();
			json.put("message", "success");
			return json.toJSONString();
		}else{
			JSONObject json = new JSONObject();
			json.put("message",  "This email: "+ login.getEmail() +". is already registered \nPlease try another email");
			return json.toJSONString();
		}
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="/editLogin", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Login editLogin(@RequestBody Login login) {
		log.info("editLogin: " + login.getEmail());
		Login entity = loginService.put(login);
		return entity;
	}
}
