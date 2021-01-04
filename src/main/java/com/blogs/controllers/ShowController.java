package com.blogs.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.blogs.dao.PostsDao;
import com.blogs.pojos.Posts;

@Controller
public class ShowController {

	@Autowired
	PostsDao pd;
	
	@GetMapping(value="/blogs/{id}")
	public ModelAndView getBlog(@PathVariable String id,Principal prin) {
		ModelAndView mv  = new ModelAndView();
		
		Posts p = pd.findOne(id);
		
		if(p == null)
			return new ModelAndView(new RedirectView("/blogs"));
		
		mv.addObject("post",p);
		String username  = 	p.getUser().getUsername();
		
		mv.addObject("username",username);
	
		if(prin!=null)
			mv.addObject("Userusername",prin.getName());
		
		mv.setViewName("show");
		return mv;
	}
	
	@GetMapping(value="/blogs/{id}/edit")
	public ModelAndView editBlog(@PathVariable String id,Principal prin) {
		ModelAndView mv  = new ModelAndView();
	
		Posts p = pd.findOne(id);
		
		
		if(p.getId() == null)
			return new ModelAndView(new RedirectView("/blogs"));
		
		if(!prin.getName().equals(p.getUser().getUsername()))
			return new ModelAndView(new RedirectView("/blogs"));
			
		
		mv.addObject("blog",p);
		mv.setViewName("editBlog");
		return mv;
	}
	@PutMapping(value="/blogs/{id}")
	public ModelAndView putBlog(@PathVariable String id,Posts p,Principal prin) {
		ModelAndView mv = new ModelAndView(new RedirectView("/blogs"));
		
		Posts post = pd.findOne(id);
		
		
		if(post.getId() == null || prin == null)
			return new ModelAndView(new RedirectView("/blogs"));
		
		if(!prin.getName().equals(post.getUser().getUsername()))
			return new ModelAndView(new RedirectView("/blogs"));
			
		
		pd.updatePost(p, id,prin.getName());
		
		return mv;
	}
	@DeleteMapping(value="/blogs/{id}")
	public ModelAndView deleteBlog(@PathVariable String id, Principal prin) {
		ModelAndView mv = new ModelAndView(new RedirectView("/blogs"));
		
		
		
		Posts p = pd.findOne(id);
		
		
		if(p.getId() == null)
			return new ModelAndView(new RedirectView("/blogs"));
		
		if(!prin.getName().equals(p.getUser().getUsername()))
			return new ModelAndView(new RedirectView("/blogs"));
			
			
		pd.deletePost(id);
		
		return mv;
	}
}
