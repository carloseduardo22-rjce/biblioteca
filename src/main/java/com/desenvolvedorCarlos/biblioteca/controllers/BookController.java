package com.desenvolvedorCarlos.biblioteca.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorCarlos.biblioteca.entities.Book;
import com.desenvolvedorCarlos.biblioteca.service.BookService;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;
import com.desenvolvedorCarlos.biblioteca.util.CustomResponse;

@RestController
@RequestMapping(value = "/Books")
public class BookController {
		
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		try {
			List<Book> result = bookService.findAll();
			return ResponseEntity.ok().body(result);
		}
		catch (Exception e) {
			throw new ObjectNotFoundException("Error returning books objects!");
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id) {
		try {
			Book result = bookService.findById(id);
			return ResponseEntity.ok().body(result);
		}
		catch (Exception e) {
			throw new ObjectNotFoundException("Error returning book object!");
		}
	}
	
	@PostMapping(value = "/NewBook")
	public ResponseEntity<CustomResponse<Book>> insert(@RequestBody Book bookObj) {
		try {
			bookService.insert(bookObj);
			Date currentDate = new Date();
			CustomResponse<Book> response = new CustomResponse<>(true, 201, "New book created sucessfuly!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<Book> errorResponse = new CustomResponse<>(false, 400, "Error when created new book!", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<Book>> deleteById(@PathVariable Integer id) {
		try {
			bookService.removeBook(id);
			Date currentDate = new Date();
			CustomResponse<Book> response = new CustomResponse<>(true, 204, "Book successfully deleted", currentDate);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<Book> errorResponse = new CustomResponse<>(false, 404, "Error when trying to delete non-existing Book", currentDate);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<Book>> update (@PathVariable Integer id, @RequestBody Book book) {
		try {
			bookService.update(id, book);
			Date currentDate = new Date();
			CustomResponse<Book> response = new CustomResponse<>(true, 201, "Book updated sucessfuly!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<Book> errorResponse = new CustomResponse<>(false, 404, "Book update failed!", currentDate);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}
	
}
