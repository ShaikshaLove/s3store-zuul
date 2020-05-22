package io.s3soft.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
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
