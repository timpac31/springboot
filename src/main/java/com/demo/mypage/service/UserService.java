package com.demo.mypage.service;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.mypage.domain.User;

@Service
public class UserService implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = sqlSession.selectOne("mappers.UserMapper.getUser", username);
		
		if(user.getUsername() == null) {
			new UsernameNotFoundException("아이디를 찾을 수 없습니다.");
		}
		
		/*
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("USER"));
		user.setAuthorities(authorities);*/
		
		return user;
	}
	
	
}
