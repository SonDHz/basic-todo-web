package com.tutorial.todo.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class I18nConfig implements WebMvcConfigurer {
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
	
	/**
	 * The LocaleResolver interface has implementations that determine the current locale based on the session, cookies, 
	 * the Accept-Language header, or a fixed value.
	 */
	@Bean
	public LocaleResolver localResolver() {
		SessionLocaleResolver srl = new SessionLocaleResolver();
		srl.setDefaultLocale(Locale.US);
		return srl;
	}
	
	/**
	 *  we need to add an interceptor bean that will switch to a new locale based on the value of the lang parameter when present on the request
	 */
	@Bean
	public LocaleChangeInterceptor localChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}
	
	/**
	 * To achieve this, our @Configuration class has to implement the WebMvcConfigurer interface and override the addInterceptors() method:
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localChangeInterceptor());
	}
}
