package com.security.SecuredLogin.UserAuthentication;

import java.util.HashSet;
import java.util.Set;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.security.SecuredLogin.Models.Role;
import com.security.SecuredLogin.Models.User;
import com.security.SecuredLogin.Repository.RoleRepo;
import com.security.SecuredLogin.Repository.UserRepo;

@Service
@Transactional
public class AuthService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private AuthenticationManager authmanager;
	
	@Autowired
	private TokenService tokenService;
	
	 public User registerUser(String username, String password){

	        String encodedPassword = encoder.encode(password);
	        Role userRole = roleRepo.findByAuthority("USER").get();

	        Set<Role> authorities = new HashSet<>();

	        authorities.add(userRole);
	        return userRepo.save(new User(username, encodedPassword, authorities));
	    }
	 
	 public String loginUser(String username, String password) {
		 try {
			Authentication auth=authmanager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		 String token=tokenService.generateJWT(auth);
		 	return token;
		 }catch (Exception e) {
			return "login failed ";
		}
		 
	 }
	
}
