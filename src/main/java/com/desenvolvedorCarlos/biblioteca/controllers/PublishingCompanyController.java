package com.desenvolvedorCarlos.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<PublishingCompany> findAll() {
		List<PublishingCompany> result = publishingCompanyService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public PublishingCompany findById(@PathVariable Integer id) {
		PublishingCompany result = publishingCompanyService.findById(id);
		return result;
	}
	
}
