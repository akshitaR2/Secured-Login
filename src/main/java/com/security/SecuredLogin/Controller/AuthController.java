package com.security.SecuredLogin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.SecuredLogin.Models.User;
import com.security.SecuredLogin.UserAuthentication.AuthService;

	@RestController
	@RequestMapping("/auth")
	@CrossOrigin("*")   //to allow for specific request type. check needy greedy 
	public class AuthController {
		
		@Autowired
		private AuthService authservice;
		
		@PostMapping("/register/{username}/{password}")
		public User register(@PathVariable String username, @PathVariable String password ) {
			return authservice.registerUser(username,password );
			
		}
		
		@PostMapping("/login/{username}/{password}")
		public String login(@PathVariable String username, @PathVariable String password ) {
			return authservice.loginUser(username,password );
			
		}
		

	}
