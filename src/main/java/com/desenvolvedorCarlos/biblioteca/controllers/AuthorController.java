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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorCarlos.biblioteca.entities.Author;
import com.desenvolvedorCarlos.biblioteca.service.AuthorService;
import com.desenvolvedorCarlos.biblioteca.util.CustomResponse;

@RestController
@RequestMapping(value = "/Authors")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@GetMapping
	public ResponseEntity<List<Author>> findAll() {
		List<Author> result = authorService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Author> findById(@PathVariable Integer id) {
		Author result = authorService.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping(value = "/NewAuthor")
	public ResponseEntity<CustomResponse<Author>> insert(@RequestBody Author authorObj) {
		try {
			authorService.insert(authorObj);
			Date currentDate = new Date();
			CustomResponse<Author> response = new CustomResponse<>(true, 201, "New author created sucessfuly!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<Author> errorResponse = new CustomResponse<>(false, 400, "Error when created new Author!", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<Author>> deleteById(@PathVariable Integer id) {
		try {
			authorService.remove(id);
			Date currentDate = new Date(); 	
			CustomResponse<Author> response = new CustomResponse<>(true, 204, "Author successfully deleted", currentDate);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<Author> errorResponse = new CustomResponse<>(false, 404, "Error when trying to delete non-existing author", currentDate);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<Author>> update (@PathVariable Integer id, @RequestBody Author author) {
		try {
			authorService.update(id, author);
			Date currentDate = new Date();
			CustomResponse<Author> response = new CustomResponse<>(true, 201, "Author updated sucessufuly!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<Author> errorResponse = new CustomResponse<>(false, 400, "Author updated failed!", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
}
