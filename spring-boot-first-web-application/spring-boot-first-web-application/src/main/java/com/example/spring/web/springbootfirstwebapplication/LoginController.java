package com.example.spring.web.springbootfirstwebapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginMessage(ModelMap model){
		//model.put("name", name);
		//System.out.println("Name is "+ name);
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomeMessage(ModelMap model, @RequestParam String name, @RequestParam String password){
		
		boolean isValidUser = service.validateUser(name, password);
		
		if(!isValidUser)
			return "login";
		
		model.put("name", name);
		model.put("password", password);
		//System.out.println("Name is "+ name);
		return "welcome";
	}
}
