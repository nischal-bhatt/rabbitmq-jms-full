package com.example.demoporject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class DirectPublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory a = new ConnectionFactory();
		Connection c = a.newConnection();
		Channel c1 = c.createChannel();
		
		String msg = "this is tv";
		
		c1.basicPublish("Direct-Exchange", "tv", null, msg.getBytes());
		
		c1.close();
		c.close();

	}

}
