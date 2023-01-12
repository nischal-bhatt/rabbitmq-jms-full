package com.example.demoporject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class DirectConsumer {

	public static void main(String[] args) throws IOException, TimeoutException
	{
		ConnectionFactory f = new ConnectionFactory();
		Connection c = f.newConnection();
		Channel c1 = c.createChannel();
		
		DeliverCallback d = 
	    		 (consumerTag,delivery ) -> {
	    			
	    			String x = new String( delivery.getBody());
	    			System.out.println(x);
	    			
	    			//c1.basicPublish("", "Queue-2", null, "hellogashti".getBytes());
	    		 };
	    
	    		 
	    		 c1.basicConsume("TV", true,d,consumerTag -> {
	    			 
	    		 });
	}
}
