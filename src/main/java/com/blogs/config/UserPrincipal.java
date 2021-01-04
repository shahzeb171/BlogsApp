package com.blogs.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.blogs.pojos.Users;

public class UserPrincipal implements UserDetails {

	/**
	 * 
	 */
	
	Users user;
	
	
	public UserPrincipal(Users user) {
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	public String getPassword() {
	
		return user.getPassword();
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
