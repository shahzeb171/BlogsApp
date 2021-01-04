package com.blogs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.Users;

public interface UsersRepository extends JpaRepository<Users, String>{

	Users findByUsername(String username);
}
