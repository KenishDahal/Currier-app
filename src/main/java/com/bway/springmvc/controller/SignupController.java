package com.bway.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.springmvc.model.User;
import com.bway.springmvc.repository.UserRepository;

@Controller
public class SignupController {
	@Autowired
	private UserRepository userRepo;
	
   @GetMapping("/signup")
	public String showSignupForm() {
		
		return "signupForm";
		
	}
   @PostMapping("/signup")
   public String doPost(@ModelAttribute User u) {
	   
	   userRepo.save(u);
	   return "loginForm";
   }
}
