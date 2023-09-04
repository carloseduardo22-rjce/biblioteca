package com.desenvolvedorCarlos.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorCarlos.biblioteca.entities.Book;
import com.desenvolvedorCarlos.biblioteca.service.BookService;

@RestController
@RequestMapping(value = "/Books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> findAll() {
		List<Book> result = bookService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Book findById(@PathVariable Integer id) {
		Book result = bookService.findById(id);
		return result;
	}
	
}
