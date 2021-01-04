package com.blogs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogs.dao.UsersDao;
import com.blogs.pojos.Users;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UsersDao ud;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users u = ud.getUser(username);
		
		if(u.getId() == null)
			throw new UsernameNotFoundException("ERROR 404! USER NOT FOUND");
		
		return new UserPrincipal(u);
	}

}
