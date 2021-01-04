package com.blogs.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.pojos.Posts;
import com.blogs.pojos.Users;
import com.blogs.repos.PostsRepository;
import com.blogs.repos.UsersRepository;

@Component
@Transactional
public class PostsDao {

	@Autowired
	PostsRepository prepo;
	@Autowired
	UsersRepository urepo;
	
	public List<Posts> allPosts(){
		
		List<Posts> list = prepo.findAll();
		
		return list;
	}
	public Posts findOne(String id) {
		
		Posts post = prepo.findById(id).orElse(new Posts());
		
		return post;
	}
	public boolean addPost(Posts post,String username) {
		
		System.out.println(post);
		
		Users user = urepo.findByUsername(username);
		
		System.out.println("Username "+username);
		post.setUser(user);
		System.out.println(user);
		prepo.save(post);
		
		return true;
	}
	public boolean updatePost(Posts post,String id,String username) {
		
		Posts p = prepo.findById(id).orElse(new Posts());
		
		if(p.getId() == null)
			return false;
		Users user = urepo.findByUsername(username);
		
		
		p.setDate(post.getDate());
		p.setDescription(post.getDescription());
		p.setTitle(post.getTitle());
		p.setUser(user);
		
		prepo.save(p);
		
		return true;
	}
	public boolean deletePost(String id) {
		Posts p = prepo.findById(id).orElse(new Posts());
		
		if(p.getId() == null)
			return false;
		
		prepo.removeById(id);
		
		return true;
	}
}
