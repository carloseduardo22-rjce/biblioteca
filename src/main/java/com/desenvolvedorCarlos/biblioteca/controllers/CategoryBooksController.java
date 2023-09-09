package com.desenvolvedorCarlos.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorCarlos.biblioteca.entities.CategoryBooks;
import com.desenvolvedorCarlos.biblioteca.service.CategoryBooksService;

@RestController
@RequestMapping(value = "/CategoryBooks")
public class CategoryBooksController {

	@Autowired
	private CategoryBooksService categoryBooksService;
	
	@GetMapping
	public List<CategoryBooks> findAll() {
		List<CategoryBooks> result = categoryBooksService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public CategoryBooks findById (@PathVariable Integer id) {
		CategoryBooks result = categoryBooksService.findById(id);
		return result;
	}
	
}
