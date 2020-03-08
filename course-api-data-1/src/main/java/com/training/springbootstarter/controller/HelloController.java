package com.training.springbootstarter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	Map<String, Integer> resultMap = new HashMap<String, Integer>();

	@RequestMapping("/hello")//get methods mapping, which is by default so we don't need to 
	//explicitly mention it
	public String greet() {
		return "hello welcome";
	}
	
	@RequestMapping("/getMap")
	public Map<String, Integer> getResultMap() {
		resultMap.put("banana", 1);
		resultMap.put("apple", 2);
		resultMap.put("strawberry", 4);
		resultMap.put("watermelon", 2);
		return resultMap;
	}
}