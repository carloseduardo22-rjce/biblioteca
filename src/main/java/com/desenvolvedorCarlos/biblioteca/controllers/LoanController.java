package com.desenvolvedorCarlos.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorCarlos.biblioteca.entities.Loan;
import com.desenvolvedorCarlos.biblioteca.service.LoanService;

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
	
}
