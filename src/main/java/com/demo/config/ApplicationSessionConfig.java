package com.demo.config;

import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.SessionRegister;

@Configuration
public class ApplicationSessionConfig {
	
	@Bean
	public ServletListenerRegistrationBean<HttpSessionListener> sessionListener() {
		return new ServletListenerRegistrationBean<HttpSessionListener>(new SessionRegister());
	}
	
}
