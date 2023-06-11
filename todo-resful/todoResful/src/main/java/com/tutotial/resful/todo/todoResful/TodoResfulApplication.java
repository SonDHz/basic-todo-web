package com.tutotial.resful.todo.todoResful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

import com.tutotial.resful.todo.todoResful.config.AppProperties;
import com.tutotial.resful.todo.todoResful.entity.LocalDatasource;

@SpringBootApplication
@EnableConfigurationProperties
public class TodoResfulApplication implements CommandLineRunner{
	
	@Autowired AppProperties appProperties;
	
	public static void main(String[] args) {
//		SpringApplication SpringApplication.run(TodoResfulApplication.class, args);
		System.out.println("=========================================");
	    
	    SpringApplication application = new SpringApplication(TodoResfulApplication.class);
	    ConfigurableEnvironment env = new StandardEnvironment();
//      Thay đổi môi trường bằng cách comment và xem kết quả
//	    Nếu không đúng profile sẽ trả ra lỗi "No qualifying bean of type 'com.tutotial.resful.todo.todoResful.entity.LocalDatasource' available"
//      env.setActiveProfiles("local");
	    env.setActiveProfiles("aws");
	    application.setEnvironment(env);
	    ApplicationContext context = application.run(args);
	    LocalDatasource localDatasource = context.getBean(LocalDatasource.class);
	    System.out.println(localDatasource);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Global variable:");
	    System.out.println("\t Email: " + appProperties.getEmail());
	    System.out.println("\t GA ID: " + appProperties.getGoogleAnalyticsId());
	    System.out.println("\t Authors: " + appProperties.getAuthors());
	    System.out.println("\t Example Map: " + appProperties.getExampleMap());
	}
}
