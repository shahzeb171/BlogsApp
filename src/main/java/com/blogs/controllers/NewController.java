package com.blogs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {

	@GetMapping(value="/blogs/new")
	public ModelAndView getNew() {
		ModelAndView mv = new  ModelAndView();
		mv.setViewName("newBlog");
		return mv;
	}
	
}
