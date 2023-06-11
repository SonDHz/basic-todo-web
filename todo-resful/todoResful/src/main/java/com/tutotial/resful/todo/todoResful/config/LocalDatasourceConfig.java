package com.tutotial.resful.todo.todoResful.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tutotial.resful.todo.todoResful.entity.LocalDatasource;

/**
 * Chỉ khi profiles là "local"
 * Thì Configuration dưới đây mới được khởi tạo
 */
@Configuration
@Profile("local")
public class LocalDatasourceConfig {
	
	@Bean
    public LocalDatasource localDatasource() {
        return new LocalDatasource("Local object, Chỉ khởi tạo khi 'local' profile active");
    }
}
