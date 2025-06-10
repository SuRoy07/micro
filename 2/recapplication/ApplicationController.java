package com.recruitment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.recruitment.proxy.ServiceProxy;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@RestController
public class ApplicationController {

	@Autowired
	private ServiceProxy proxy;
	
	@GetMapping(value="/greet")
	@CircuitBreaker(name="myCircuitBreaker",fallbackMethod="fallback")
	
	public String retreiveInfo( ) {
		
		return proxy.greeting();
		
	}
	
	public String fallback(Exception e) {
		return "Sorry Service is unavailable";
	}
	
}
	 	  	    	    		        	 	
