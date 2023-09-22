package com.desenvolvedorCarlos.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvedorCarlos.biblioteca.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{
	
}
