package com.security.SecuredLogin.UserAuthentication;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.SecuredLogin.Models.Role;
import com.security.SecuredLogin.Models.User;
import com.security.SecuredLogin.Repository.UserRepo;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepo userRepo;
	
	private static final Logger log= LoggerFactory.getLogger(UserService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("inside loadUserByUsername");
		return userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user not found"));
		
//		if(!username.equals("test"))
//			throw new UsernameNotFoundException(username+" is not found");
//		Set<Role> role= new HashSet<Role>();
////		role.add(new Role(1,"ADMIN"));
//		role.add(new Role(2,"USER"));
//		return new User(1,"test",encoder.encode("password"),role);
	}

}
