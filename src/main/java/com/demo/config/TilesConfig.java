package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfig {
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "WEB-INF/xml/tiles.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer; 
	}
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
	    UrlBasedViewResolver tilesViewResolver = new UrlBasedViewResolver();
	    tilesViewResolver.setViewClass(TilesView.class);
	    return tilesViewResolver;
	}

}
