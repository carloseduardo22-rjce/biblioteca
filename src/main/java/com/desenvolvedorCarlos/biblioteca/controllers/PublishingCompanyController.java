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
			CustomResponse<PublishingCompany> response = new CustomResponse<>(true, 201, "New PublishingCompany created!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<PublishingCompany> errorResponse = new CustomResponse<>(false, 400, "Error when entering new PublishingCompany!", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<PublishingCompany>> deleteById(@PathVariable Integer id) {
		try {
			publishingCompanyService.removePublishingCompany(id);
			Date currentDate = new Date();
			CustomResponse<PublishingCompany> response = new CustomResponse<>(true, 201, "Publishing successfully deleted", currentDate);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<PublishingCompany> errorResponse = new CustomResponse<>(false, 400, "Error when trying to delete non-existing PublishingCompany", currentDate);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CustomResponse<PublishingCompany>> update (@PathVariable Integer id, @RequestBody PublishingCompany publishingCompany) {
		try {
			publishingCompanyService.update(id, publishingCompany);
			Date currentDate = new Date();
			CustomResponse<PublishingCompany> response = new CustomResponse<>(true, 201, "Publishing Company update sucessfuly!", currentDate);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		catch (Exception e) {
			Date currentDate = new Date();
			CustomResponse<PublishingCompany> errorResponse = new CustomResponse<>(false, 400, "Publishing Company updated failed!", currentDate);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
		}
	}
	
}
