package com.desenvolvedorCarlos.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desenvolvedorCarlos.biblioteca.entities.PublishingCompany;
import com.desenvolvedorCarlos.biblioteca.service.PublishingCompanyService;

@RestController
@RequestMapping(value = "/PublishingCompanys")
public class PublishingCompanyController {
	
	@Autowired
	private PublishingCompanyService publishingCompanyService;
	
	@GetMapping
	public 	ResponseEntity<List<PublishingCompany>> findAll() {
		List<PublishingCompany> result = publishingCompanyService.findAll();
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/{id}")
	public PublishingCompany findById(@PathVariable Integer id) {
		PublishingCompany result = publishingCompanyService.findById(id);
		return result;
	}
	
}
