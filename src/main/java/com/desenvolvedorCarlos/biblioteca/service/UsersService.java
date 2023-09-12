package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Users;
import com.desenvolvedorCarlos.biblioteca.repository.UsersRepository;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Transactional(readOnly = true)
	public Users findById(Integer id) {
		Optional<Users> obj = usersRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("User not found!"));
	}
	
	@Transactional(readOnly = true)
	public List<Users> findAll(){
		List<Users> result = usersRepository.findAll();
		return result;
	}
	
}
