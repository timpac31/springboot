package com.demo.mypage.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;

@Configuration
public class LoginConfig {
	
	@Bean
	public GoogleConnectionFactory googleConnectionFactory() {
		return new GoogleConnectionFactory("423980485836-gfgje2ioes1gbk3p2qo48lmsrdmv5krj.apps.googleusercontent.com", "QLmi8MCPuV8BYzus_BPmTHYu");
	}
	
	@Bean
	public OAuth2Parameters googleOAuth2Parameters() {
		OAuth2Parameters googleOAuth2Parameters = new OAuth2Parameters();
		googleOAuth2Parameters.setScope("https://www.googleapis.com/auth/plus.login");
		//googleOAuth2Parameters.setScope("https://www.googleapis.com/auth/plus.me");
		
		googleOAuth2Parameters.setRedirectUri("http://localhost:8080/oAuthCallback.do");
		return googleOAuth2Parameters;
	}
	
	

}

