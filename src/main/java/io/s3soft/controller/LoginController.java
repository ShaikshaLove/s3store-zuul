package io.s3soft.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.s3soft.api.consumer.User;
import io.s3soft.api.consumer.UserApiConsumer;
import io.s3soft.dto.UserDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,
		                 RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class LoginController {
	@Autowired
	private UserApiConsumer userApiConsumer;
	
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
	
	@GetMapping("/me")
	@ResponseBody
	public UserDto getUser(Principal principal) {
		User user=userApiConsumer.getUser(principal.getName()).getContent();
		return new UserDto(user.getUserId(),user.getFirstName());
	}
   
}
