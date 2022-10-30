package com.bway.springmvc.controller;
//
//import javax.persistence.PostUpdate;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bway.springmvc.model.Currier;
import com.bway.springmvc.model.Pending;
import com.bway.springmvc.model.User;
//import com.bway.springmvc.model.Employee;
//import com.bway.springmvc.model.Pending;
//import com.bway.springmvc.model.User;
import com.bway.springmvc.repository.CurrierRepository;
import com.bway.springmvc.repository.PendingRepository;
//import com.bway.springmvc.repository.PendingRepository;
//import com.bway.springmvc.repository.UserRepository;

@Controller
public class IndexController {
	
	@Autowired
	private CurrierRepository curRepo;	
	
	@Autowired
	private PendingRepository pendingRepo;	
	
 @GetMapping("/")
	public String mainPage() {
		
		return "indexPage";
	}
 
 @GetMapping("/package")
	public String doGet( HttpSession session) {

		if (session.getAttribute("validuser") == null) {
			return "indexPage";
		}
		return "currier";
	}
 
 //currier 
 @PostMapping("/package")
	public String doPost(@ModelAttribute Currier c, HttpSession session) {
	 
	 User u = (User) session.getAttribute("validuser");
//	 System.out.println("first name = "+u.getFname());

	    c.setUser(u);
	    
		curRepo.save(c);
		return "currier";
	}
  
 @GetMapping("/order")
	public String getList(Model model,HttpSession session) {
//		if(session.getAttribute("validuser") ==  ){
	 
		model.addAttribute("orderList", curRepo.findAll());
				
		return "order";
		
	}
 
 //Same like Edit 
 @GetMapping("/add")
 public String add(@RequestParam Integer id,Model model) {
	 
	 model.addAttribute("addList", curRepo.getById(id) );	 
	 
	return "editPending";
	 
 }
// 
// 
//@GetMapping("/save")
// public String save(Model model,@RequestParam Integer id) {
////	Currier get = curRepo.getById(id);
////    pendingRepo.save(curRepo.getById(id));
//
//		model.addAttribute("saveList", curRepo.getById(id) );
////	model.addAttribute("saveList", pendingRepo.getById(id) );
//
//	return "save";
//	 
// }


@GetMapping("/pendingList")
public String show(Model model) {	
	
	model.addAttribute("pList", pendingRepo.findAll());
	
	return "showPending"; 
}


@PostMapping("/pending")
public String save(@ModelAttribute Pending p) {
	
//	if (session.getAttribute("validuser") == null) {
//		return "indexPage";
//	}	
	pendingRepo.save(p);
	
	return "redirect:pendingList"; 
}

//pendind list deletion
@GetMapping("/success")
public String pendingSuccess(@RequestParam Integer id,Model model) {
	
	
	model.addAttribute("del", pendingRepo.getById(id));
	pendingRepo.deleteById(id);
	
	
	
	return "success";	
}

// orderlist list deletion
@GetMapping("/delete")
public String 	orderSuccess(@RequestParam Integer id,Model model) {
	
	
	
	
	curRepo.deleteById(id);
	
	
	return "success";	
}



}
