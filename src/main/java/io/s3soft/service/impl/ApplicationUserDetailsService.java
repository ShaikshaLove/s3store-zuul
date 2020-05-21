package io.s3soft.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.s3soft.api.consumer.User;
import io.s3soft.api.consumer.UserApiConsumer;
import io.s3soft.dto.ApplicationUserDetails;
@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserApiConsumer userApiConsumer;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User applicationUser=userApiConsumer.getUser(username).getContent();
		System.out.println(applicationUser);
		
		return new ApplicationUserDetails(authorities(applicationUser.getRoles()),applicationUser.getEmail(),applicationUser.getPassword(),true,true,true,true);
	}
	List<SimpleGrantedAuthority> authorities(List<String> roles){
		ArrayList<SimpleGrantedAuthority> authorities=new ArrayList<>();
		 roles.forEach(role->authorities.add(new SimpleGrantedAuthority(role)));
		return authorities;
	}

}
