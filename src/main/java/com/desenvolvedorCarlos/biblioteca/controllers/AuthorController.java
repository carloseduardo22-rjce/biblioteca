package com.desenvolvedorCarlos.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorCarlos.biblioteca.entities.Author;
import com.desenvolvedorCarlos.biblioteca.service.AuthorService;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public List<Author> findAll() {
		List<Author> result = authorService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Author findById(@PathVariable Integer id) {
		Author result = authorService.findById(id);
		return result;
	}
	
}
