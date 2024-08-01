package com.security.SecuredLogin;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.SecuredLogin.Models.Role;
import com.security.SecuredLogin.Models.User;
import com.security.SecuredLogin.Repository.RoleRepo;
import com.security.SecuredLogin.Repository.UserRepo;

@SpringBootApplication
public class SecuredLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuredLoginApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepo roleRepository,UserRepo userRepository, PasswordEncoder passwordEncoder) {
		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));

			Set<Role> roles = new HashSet<>();
			roles.add(adminRole);

			User admin = new User( "Admin", passwordEncoder.encode("password"), roles);

			userRepository.save(admin);
		};
	}

}
