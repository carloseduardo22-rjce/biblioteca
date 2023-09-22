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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorCarlos.biblioteca.entities.Users;
import com.desenvolvedorCarlos.biblioteca.service.UsersService;
import com.desenvolvedorCarlos.biblioteca.util.CustomResponse;

@RestController
@RequestMapping(value = "/Users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@GetMapping
	public 	ResponseEntity<List<Users>> findAll(){
		List<Users> result = usersService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/{id}")
	public Users findById(@PathVariable Integer id) {
		Users result = usersService.findById(id);
		return result;
	}
	
	@PostMapping(value = "/NewUser")
	public ResponseEntity<CustomResponse<Users>> insert(@RequestBody Users UsersObj) {
		try {
			usersService.insert(UsersObj);
			Date currentDate = new Date();
			CustomResponse<Users> response = new CustomResponse<>(true, 201, "New user registered!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<Users> errorResponse = new CustomResponse<>(false, 400, "Error when entering new user!", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<Users>> delete (@PathVariable Integer id) {
		try {
			usersService.removeUser(id);
			Date currentDate = new Date();
			CustomResponse<Users> response = new CustomResponse<>(true, 201, "User sucessfully deleted", currentDate);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<Users> errorResponse = new CustomResponse<>(false, 400, "Error when trying to delete non-existing User", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
}
