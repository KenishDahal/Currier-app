package com.bway.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.bway.springmvc.model.User;
import com.bway.springmvc.repository.UserRepository;

@Controller
public class LoginController {
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/login")
	public String showLogin() {
		
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String doLogin(@ModelAttribute User u,Model model,HttpSession session) {
		User usr = userRepo.findByUsernameAndPassword(u.getUsername(),u.getPassword());
		
		if(usr != null) {
			
			session.setAttribute("validuser", usr);	
//			User u1 = (User) session.getAttribute("validuser");
//			 System.out.println("first name = "+u1.getFname());
		return "currier";
		}
		
		return "loginForm";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();
		
		return "loginForm";
	}
	
	

}
