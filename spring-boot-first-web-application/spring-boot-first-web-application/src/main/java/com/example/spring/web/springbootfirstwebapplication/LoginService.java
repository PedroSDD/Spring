package com.example.spring.web.springbootfirstwebapplication;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class LoginService {
	
	public boolean validateUser(String userid, String password){
		return userid.equalsIgnoreCase("in28Minutes") && password.equalsIgnoreCase("dummy");
	}

}
