package com.blogs.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogs.pojos.Posts;

public interface PostsRepository extends JpaRepository<Posts, String>{
String removeById(String id);
}
