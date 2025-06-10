package com.plantnursery.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "PlantNurseryGreeting")
public interface ServiceProxy {

    @RequestMapping("/welcome")
    public String greeting();
}
