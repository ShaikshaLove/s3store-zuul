package io.s3soft.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,
		                 RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class DashboardController {
	
	@GetMapping({"/dashboard"})
	public String home(Principal principal,ModelMap map) {
		map.addAttribute("username",principal.getName());
		return "dashboard";
	}
	
	
	@GetMapping("/access-denied")
	public String accessDenied(Principal principal,ModelMap map) {
		map.addAttribute("username",principal.getName());
		return "access-denied";
	}	

}
