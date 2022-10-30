package com.bway.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bway.springmvc.repository.EmployeeRepository;

@Controller
public class AdminController {
	
	@Autowired
	private EmployeeRepository empRepo;
	
@GetMapping("/admin")	
public String doGet() {
	
	return "admin";                         
	
}

@GetMapping("/employee")
public String empDetails(Model model) {	
	
	model.addAttribute("empDtl", empRepo.findAll());
	return "empDetails";

}




}
