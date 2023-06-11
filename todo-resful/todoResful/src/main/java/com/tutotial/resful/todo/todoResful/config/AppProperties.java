package com.tutotial.resful.todo.todoResful.config;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component // spring bean
//@PropertySource("classpath:loda.yml") // Specify which file to get the configuration from
@ConfigurationProperties(prefix = "loda") // Only get configs prefix with "loda"
public class AppProperties {
	private String email;
    private String googleAnalyticsId;

    private List<String> authors;

    private Map<String, String> exampleMap;
    
    
}
