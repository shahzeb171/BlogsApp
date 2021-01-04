package com.blogs.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.blogs.dao.PostsDao;
import com.blogs.pojos.Posts;

@Controller
public class IndexController {

	@Autowired
	PostsDao pd;
	
	@GetMapping(value="/")
	public ModelAndView redIndex() {
		
		ModelAndView mv = new ModelAndView(new RedirectView("/blogs"));		
		
		return mv;
	}
	@GetMapping(value="/blogs")
	public ModelAndView getBlogs(Principal p) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("allPosts",	pd.allPosts());
		
		System.out.println(pd.allPosts());
		if(p == null)
			mv.addObject("loggedIn",false);
		else
			mv.addObject("loggedIn",true);
		mv.setViewName("index");
		
		return mv;
	}
	@PostMapping(value="/blogs")
	public ModelAndView postBlogs(Posts post,Principal p) {
		ModelAndView mv = new ModelAndView();
		
		if(p==null)
			return new ModelAndView(new RedirectView("/login"));
			
	
		System.out.println(post);
		System.out.println("Principal "+p);
		
		String username = p.getName();
		if(	pd.addPost(post, username ) )
			return new ModelAndView(new RedirectView("/blogs"));
		
		mv.setViewName("newBlog");
		
		return mv;
	}
	@GetMapping(value="/user")
	@ResponseBody
	public Principal geet(Principal p) {
		return p;
	}
	
}
