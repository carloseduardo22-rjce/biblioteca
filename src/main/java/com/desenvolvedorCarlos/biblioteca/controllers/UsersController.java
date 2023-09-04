package com.desenvolvedorCarlos.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorCarlos.biblioteca.entities.Users;
import com.desenvolvedorCarlos.biblioteca.service.UsersService;

@RestController
@RequestMapping(value = "/Users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping
	public List<Users> findAll(){
		List<Users> result = usersService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Users findById(@PathVariable Integer id) {
		Users result = usersService.findById(id);
		return result;
	}
	
}
