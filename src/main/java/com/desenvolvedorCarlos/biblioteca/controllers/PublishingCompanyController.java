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

import com.desenvolvedorCarlos.biblioteca.entities.PublishingCompany;
import com.desenvolvedorCarlos.biblioteca.service.PublishingCompanyService;
import com.desenvolvedorCarlos.biblioteca.util.CustomResponse;

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
	
	@PostMapping(value = "/NewPublishingCompany")
	public ResponseEntity<CustomResponse<PublishingCompany>> insert(@RequestBody PublishingCompany publishingCompanyObj) {
		try {
			publishingCompanyService.insert(publishingCompanyObj);
			Date currentDate = new Date();
			CustomResponse<PublishingCompany> response = new CustomResponse<>(true, 201, "New PublishingCompany registered!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<PublishingCompany> errorResponse = new CustomResponse<>(false, 400, "Error when entering new PublishingCompany!", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
}
