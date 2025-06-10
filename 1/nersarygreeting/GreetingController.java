package com.plantnursery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(value = "/welcome")
    public @ResponseBody String greeting() {
        return "Welcome to Nature Love Plant Nursery!!!!!";
    }
}
