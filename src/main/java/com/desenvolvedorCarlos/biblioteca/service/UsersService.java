package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desenvolvedorCarlos.biblioteca.entities.Users;
import com.desenvolvedorCarlos.biblioteca.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public Users findById(Integer id) {
		Users result = usersRepository.findById(id).get();
		return result;
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<Users> findAll(){
		List<Users> result = usersRepository.findAll();
		return result;
	}
	
}
