package com.security.SecuredLogin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.security.SecuredLogin.Models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);
	
}
