package com.example.demoporject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {

	@GetMapping ("/publish")
	public void publishMessage(@RequestParam String id) throws IOException, TimeoutException
	{
		System.out.println("nish priting");
	   	System.out.println(id);
	   	
	   	PushToQueue a = new PushToQueue();
	   	a.push(id);
	}
}
