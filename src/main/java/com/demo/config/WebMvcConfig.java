package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
		
		registry.addViewController("/dict/javascript.do").setViewName("dict/javascript");
		registry.addViewController("/dict/jsp.do").setViewName("dict/jsp");
		registry.addViewController("/dict/java.do").setViewName("dict/java");
	}
	
}
