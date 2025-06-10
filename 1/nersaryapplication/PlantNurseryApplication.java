package com.plantnursery.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.plantnursery.controller", "com.plantnursery.proxy"})
@ComponentScan(basePackages = {"com.plantnursery.*"})
public class PlantNurseryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlantNurseryApplication.class, args);
    }
}
