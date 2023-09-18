package com.desenvolvedorCarlos.biblioteca.controllers;

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

import com.desenvolvedorCarlos.biblioteca.entities.CategoryBooks;
import com.desenvolvedorCarlos.biblioteca.service.CategoryBooksService;
import com.desenvolvedorCarlos.biblioteca.util.CustomResponse;

@RestController
@RequestMapping(value = "/CategoryBooks")
public class CategoryBooksController {
	
	@Autowired
	private CategoryBooksService categoryBooksService;
	
	@GetMapping
	public ResponseEntity<List<CategoryBooks>> findAll() {
		List<CategoryBooks> result = categoryBooksService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryBooks> findById (@PathVariable Integer id) {
		CategoryBooks result = categoryBooksService.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping(value = "/NewCategoryBook")
	public ResponseEntity<CustomResponse<CategoryBooks>> insert(@RequestBody CategoryBooks categoryBooksObj) {
		try {
			categoryBooksService.insert(categoryBooksObj);
			Date currentDate = new Date();
			CustomResponse<CategoryBooks> response = new CustomResponse<>(true, 201, "Book category created sucessfuly!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<CategoryBooks> errorResponse = new CustomResponse<>(false, 400, "Error when created category of book!", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
}
