package com.example.demoporject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

@SpringBootApplication
public class DemoPorject3Application {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(DemoPorject3Application.class, args);
	    //consumer can also publish out once it consumes
	    ConnectionFactory f = new ConnectionFactory();
	    Connection c = f.newConnection();
	    
	    Channel c1 = c.createChannel();
	    
	    DeliverCallback d = 
	    		 (consumerTag,delivery ) -> {
	    			
	    			String x = new String( delivery.getBody());
	    			System.out.println(x);
	    			
	    			c1.basicPublish("", "Queue-2", null, "hellogashti".getBytes());
	    		 };
	    
	    		 
	    		 c1.basicConsume("Queue-1", true,d,consumerTag -> {
	    			 
	    		 });
	}

}
