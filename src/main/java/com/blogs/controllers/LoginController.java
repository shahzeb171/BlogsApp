package com.blogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.blogs.dao.UsersDao;
import com.blogs.pojos.Users;

@Controller
public class LoginController {

	@Autowired
	UsersDao ud;
	@GetMapping(value="/login")
	public ModelAndView getLogin() {
		return new ModelAndView("login");
	}
	@GetMapping(value="/signup")
	public ModelAndView getSignup() {
		return new ModelAndView("signup");
	}
	@PostMapping(value="/signup")
	public ModelAndView postSignup(Users u) {
		ModelAndView mv = new ModelAndView(new RedirectView("/blogs"));
		
		if(!ud.signup(u))
			return new ModelAndView("signup");
	
		return mv;
	}
}
