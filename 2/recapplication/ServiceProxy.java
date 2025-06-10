package com.recruitment.proxy;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.cloud.openfeign.FeignClient;   
@FeignClient(name="RestaurantGreeting" )
public interface ServiceProxy {
	
	   @RequestMapping("/welcome")
	   public String greeting();
//	   @RequestMapping(value="/welcome/{name}")
//	   public String greeting( String name);
	   

}
