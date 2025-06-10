package com.plantnursery.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.plantnursery.controller"})
public class PlantNurseryGreetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantNurseryGreetingApplication.class, args);
    }
}
