package com.blogs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.blogs.pojos.Users;
import com.blogs.repos.UsersRepository;

@Component
public class UsersDao {

	@Autowired
	UsersRepository urepo;
	
	
	public Users getUser(String username) {
		return urepo.findByUsername(username);
	}
	
	public boolean signup(Users user) {
		
		Users u = urepo.findByUsername(user.getUsername());
		
		if(u != null)
			return false;
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		urepo.save(user);
		
		return true;
	}
}
