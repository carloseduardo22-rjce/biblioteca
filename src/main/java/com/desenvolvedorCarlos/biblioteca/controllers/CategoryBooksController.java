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

import com.desenvolvedorCarlos.biblioteca.entities.CategoryBooks;
import com.desenvolvedorCarlos.biblioteca.service.CategoryBooksService;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;
import com.desenvolvedorCarlos.biblioteca.util.CustomResponse;

@RestController
@RequestMapping(value = "/CategoryBooks")
public class CategoryBooksController {
	
	@Autowired
	private CategoryBooksService categoryBooksService;
	
	@GetMapping
	public ResponseEntity<List<CategoryBooks>> findAll() {
		try {
			List<CategoryBooks> result = categoryBooksService.findAll();
			return ResponseEntity.ok().body(result);
		}
		catch (Exception e) {
			throw new ObjectNotFoundException("Error returning CategoryBooks objects!");
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryBooks> findById (@PathVariable Integer id) {
		try {
			CategoryBooks result = categoryBooksService.findById(id);
			return ResponseEntity.ok().body(result);
		}
		catch (Exception e) {
			throw new ObjectNotFoundException("Error returning CategoryBook object!");
		}
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
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<CategoryBooks>> deleteById(@PathVariable Integer id) {
		try {
			categoryBooksService.removeCategory(id);
			Date currentDate = new Date();
			CustomResponse<CategoryBooks> response = new CustomResponse<>(true, 204, "CategoryBook successfully deleted", currentDate);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<CategoryBooks> errorResponse = new CustomResponse<>(false, 404, "Error when trying to delete non-existing CategoryBook", currentDate);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<CategoryBooks>> update (@PathVariable Integer id, @RequestBody CategoryBooks categoryBooks) {
		try {
			categoryBooksService.update(id, categoryBooks);
			Date currentDate = new Date();
			CustomResponse<CategoryBooks> response = new CustomResponse<>(true, 201, "Category Books updated sucessfuly", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<CategoryBooks> errorResponse = new CustomResponse<>(false, 404, "Category Books updated failed ", currentDate);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}
	
}
