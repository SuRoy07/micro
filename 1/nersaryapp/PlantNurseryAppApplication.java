package com.plantnursery.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.plantnursery.model", "com.plantnursery.controller", "com.plantnursery.service", "com.plantnursery.exception", "com.plantnursery.validation"})
public class PlantNurseryAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantNurseryAppApplication.class, args);
    }

}
