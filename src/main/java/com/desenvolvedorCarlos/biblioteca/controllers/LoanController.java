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

import com.desenvolvedorCarlos.biblioteca.entities.Loan;
import com.desenvolvedorCarlos.biblioteca.service.LoanService;
import com.desenvolvedorCarlos.biblioteca.util.CustomResponse;

@RestController
@RequestMapping(value = "/Loans")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@GetMapping
	public ResponseEntity<List<Loan>> findAll() {
		List<Loan> result = loanService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Loan> findById(@PathVariable Integer id) {
		Loan result = loanService.findById(id);
		return ResponseEntity.ok().body(result);
	}
	
	@PostMapping(value = "/NewLoan")
	public ResponseEntity<CustomResponse<Loan>> insert(@RequestBody Loan loanObj) {
		try {
			loanService.insert(loanObj);
			Date currentDate = new Date();
			CustomResponse<Loan> response = new CustomResponse<>(true, 201, "New loan successfully registered!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<Loan> errorResponse = new CustomResponse<>(false, 400, "Error when entering new loan!", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<Loan>> delete (@PathVariable Integer id) {
		try {
			loanService.removeLoan(id);
			Date currentDate = new Date();
			CustomResponse<Loan> response = new CustomResponse<>(true, 201, "Loan sucessfully deleted", currentDate);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<Loan> errorResponse = new CustomResponse<>(false, 400, "Error when trying to delete non-existing Loan", currentDate);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}
	
}
