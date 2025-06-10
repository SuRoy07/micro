package com.plantnursery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.plantnursery.proxy.ServiceProxy;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ApplicationController {

    @Autowired
    private ServiceProxy proxy;

    @GetMapping(value = "/greet")
    @CircuitBreaker(name = "myCircuitBreaker", fallbackMethod = "fallback")
    public String retreiveInfo() {
        return proxy.greeting();
    }

    public String fallback(Exception e) {
        return "Sorry Service is unavailable";
    }
}
