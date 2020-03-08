package com.training.springbootstarter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")//get methods mapping, which is by default so we don't need to 
	//explicitly mention it
	public String greet() {
		return "hello welcome";
	}
}