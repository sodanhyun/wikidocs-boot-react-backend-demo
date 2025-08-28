package com.packt.cardatabase.domain.repository;

import java.util.Optional;

import com.packt.cardatabase.domain.AppUser;
import org.springframework.data.repository.CrudRepository;

public interface AppUserRepository extends CrudRepository<AppUser, Long> {
	Optional<AppUser> findByUsername(String username);
}