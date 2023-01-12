package com.example.demoporject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@SpringBootApplication
public class DemoPorject2Application {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(DemoPorject2Application.class, args);
	
	    ConnectionFactory f = new ConnectionFactory();
	    Connection c = f.newConnection();
	    
	    Channel channel  = c.createChannel();
	    
	   // String message = "First message from rabbit - 1 - 1 22";
	    
	    String[] messages = {"1","2","3"};
	    
	    for (String m: messages)
	    {
	    	 channel.basicPublish("", "Queue-1" , null, m.getBytes()); 	
	    }
	    
	   
	    
	    channel.close();
	    c.close();
	}

}
