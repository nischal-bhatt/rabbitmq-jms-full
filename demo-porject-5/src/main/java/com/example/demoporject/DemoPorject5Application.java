package com.example.demoporject;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@SpringBootApplication
public class DemoPorject5Application {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(DemoPorject5Application.class, args);
	
	ConnectionFactory c = new ConnectionFactory();
	Connection c1 = c.newConnection();
	Channel c2 = c1.createChannel();
	
	String msg = "message for mobiule and ac ";
	
	c2.basicPublish("Fanout-Exchange", "", null, msg.getBytes());
	
	c2.close();
	c1.close();
	
	}

}
