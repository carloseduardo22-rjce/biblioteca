package com.desenvolvedorCarlos.biblioteca.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorCarlos.biblioteca.entities.Book;
import com.desenvolvedorCarlos.biblioteca.entities.CategoryBooks;
import com.desenvolvedorCarlos.biblioteca.service.BookService;
import com.desenvolvedorCarlos.biblioteca.util.CustomResponse;

@RestController
@RequestMapping(value = "/Books")
public class BookController {
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		List<Book> result = bookService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id) {
		Book result = bookService.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping(value = "/NewCategoryBook")
	public ResponseEntity<CustomResponse<Book>> insert(@RequestBody Book bookObj) {
		try {
			bookService.insert(bookObj);
			Date currentDate = new Date();
			String formattedDate = dateFormat.format(currentDate);
			CustomResponse<Book> response = new CustomResponse<>(true, 201, "Categoria de livro criada com sucesso!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			String formattedDate = dateFormat.format(currentDate);
			CustomResponse<Book> errorResponse = new CustomResponse<>(true, 400, "Erro ao criar a categoria de livro", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
}
