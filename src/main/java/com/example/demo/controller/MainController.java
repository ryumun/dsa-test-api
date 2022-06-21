package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String main(HttpServletRequest request) {
		String module_name = env.getProperty("module_name");
		request.setAttribute("module_name", module_name);
		return "index.html";
	}
	
	
}
