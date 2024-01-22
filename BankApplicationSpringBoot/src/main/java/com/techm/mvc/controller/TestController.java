package com.techm.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TestController {
	
	@RequestMapping("/user")
	public String hello()   
	{  
	return "jsp/index.jsp";  
	}  

}
