package com.demo.mypage.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
	private static final long serialVersionUID = 3091575983616303882L;
	
	private String id;			//mapping username
	private String social_no;	//mapping password
	private String name;
	
	private Collection<? extends GrantedAuthority> authorities; 
	private boolean accountNonExpired = true; 
	private boolean accountNonLocked = true; 
	private boolean credentialsNonExpired = true; 
	private boolean enabled = true;
	
	public String getUsername() {
		return id;
	}
	public void setUsername(String id) {
		this.id = id;
	}
	public String getPassword() {
		return social_no;
	}
	public void setPassword(String social_no) {
		this.social_no = social_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	

	
}
