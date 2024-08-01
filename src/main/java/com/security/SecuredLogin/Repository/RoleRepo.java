package com.security.SecuredLogin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.SecuredLogin.Models.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{

	Optional<Role> findByAuthority(String string);

}
