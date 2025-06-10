package com.recruitment.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.recruitment.model","com.recruitment.controller","com.recruitment.service","com.recruitment.exception"})
@EnableDiscoveryClient
public class RecruitmentAgencyApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecruitmentAgencyApplication.class, args);
	}

}
