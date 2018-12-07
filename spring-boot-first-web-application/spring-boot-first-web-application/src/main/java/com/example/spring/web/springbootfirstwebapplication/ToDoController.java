package com.example.spring.web.springbootfirstwebapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ToDoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model){
		//model.put("name", name);
		//System.out.println("Name is "+ name);
		model.put("todos", service.retrieveTodos("in28Minutes"));
		return "list-todos";
	}
}
