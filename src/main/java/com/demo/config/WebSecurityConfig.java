package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.demo.mypage.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserService userService;
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring().antMatchers("/css/**", "/js/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests() 
			.antMatchers("/board/writeForm.do", "/board/modifyForm.do").authenticated()
			//.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/**").permitAll()
			.anyRequest().authenticated() 
			
			.and() 
			.formLogin()
				.loginPage("/login.do")
				.usernameParameter("id")
				.passwordParameter("password")
				.permitAll()
				
			.and()
			.logout().permitAll()
			.and().csrf().disable();

	}
	
	@Override protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
		auth.userDetailsService(userService); 
	}

	
	/*
	@Autowired
 	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 		auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
 	}*/

}
