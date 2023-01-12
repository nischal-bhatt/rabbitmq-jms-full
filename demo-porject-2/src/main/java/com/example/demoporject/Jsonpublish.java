package com.example.demoporject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.json.JSONObject;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Jsonpublish {

	public static void main(String[] args) throws IOException, TimeoutException {
		  ConnectionFactory f = new ConnectionFactory();
		    Connection c = f.newConnection();
		    
		    Channel channel  = c.createChannel();
		    
		   // String message = "First message from rabbit - 1 - 1 22";
		    
		    String[] messages = {"1","2","3"};
		    
		    JSONObject json = new JSONObject();
		    json.put("hi", "yolo");
		    json.put("bye", "mc");
		    
		     channel.basicPublish("", "Queue-1" , null, json.toString().getBytes()); 	
		    
		    
		   
		    
		    channel.close();
		    c.close();

	}

}
