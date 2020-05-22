package io.s3soft.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,
        RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
@Controller
public class LoginController {
	
	
	@GetMapping("/perform-login")
	public String loginPage(@RequestParam(value="logout",defaultValue = "false")boolean logout,@RequestParam(value="authError",required = false)boolean authError,ModelMap map) {
		if(authError) {
			map.addAttribute("authError","UserName or Password are incorrect");
		}
		if(logout) {
			map.addAttribute("logout","You have been logged out!!");
		}
		
		return "login";
	}
	
}
