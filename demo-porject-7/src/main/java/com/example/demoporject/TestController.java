package com.example.demoporject;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

	   @Autowired
	   RabbitTemplate rt;
	
	   @GetMapping("/test/{name}")
	   public String testAPI(@PathVariable("name") String name) {
		  
		   Person p = new Person(1L, name);
		   
		   rt.convertAndSend("Mobile",p);
		   
		   
		   
		   return "Success";
	   }
	   
}
