package io.s3soft.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.s3soft.api.consumer.User;
import io.s3soft.api.consumer.UserApiConsumer;
import io.s3soft.dto.UserDto;
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.DELETE,
        RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class UserController {
	
	@GetMapping("/me")
	public UserDto getUser(Principal principal) {
		User user=userApiConsumer.getUser(principal.getName()).getContent();
		return new UserDto(user.getUserId(),user.getFirstName(),user.getEmail());
	}
	@Autowired
	private UserApiConsumer userApiConsumer;

}
