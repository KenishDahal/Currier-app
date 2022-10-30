package com.bway.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springmvc.model.Employee;
import com.bway.springmvc.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository empRepo;
	
	// Employee login get and post mapping
	
	@GetMapping("/empLogin")
	public String getLogin() {	
		
		return "empLoginForm";
	
	}
	
	@PostMapping("/empLogin")
	public String doLogin(@ModelAttribute Employee e) {
		
		Employee emp = empRepo.findByFnameAndPassword(e.getFname(),e.getPassword());
		
		if(emp != null) {
		return "employeeMainPage";
		}
		return "empLoginForm";
		
	}
	
	
	
	// end of employee login get and post mapping...
	
	
	// employee signup get and post mapping...
	@GetMapping("/empSignup")
	public String doGet() {	
		
		return "empSignupForm";
	
	}
	@PostMapping("/empSignup")
	public String doPost(@ModelAttribute Employee e) {
		
		empRepo.save(e);
		
		return "empLoginForm";
		
	}
	                                
	@GetMapping("/empMainPage")
	public String getMainPage() {	
		
		return "employeeMainPage";
	
	}
	
	
}
