package com.tutotial.resful.todo.todoResful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.tutotial.resful.todo.todoResful.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class TodoResfulApplication implements CommandLineRunner{
	
	@Autowired AppProperties approperties;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoResfulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Global variable:");
	    System.out.println("\t Email: " + approperties.getEmail());
	    System.out.println("\t GA ID: " + approperties.getGoogleAnalyticsId());
	    System.out.println("\t Authors: " + approperties.getAuthors());
	    System.out.println("\t Example Map: " + approperties.getExampleMap());
	}

}
