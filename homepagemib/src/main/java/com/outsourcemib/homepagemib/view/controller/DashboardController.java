package com.outsourcemib.homepagemib.view.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {
 
	@RequestMapping(value="/dashboardIndex")
	public String setupForm(Map<String, Object> map) {
		return "dashboard";
	}

}
