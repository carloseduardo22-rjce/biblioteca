package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desenvolvedorCarlos.biblioteca.entities.PublishingCompany;
import com.desenvolvedorCarlos.biblioteca.repository.PublishingCompanyRepository;

@Service
public class PublishingCompanyService {

	@Autowired
	private PublishingCompanyRepository publishingCompanyRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public PublishingCompany findById(Integer id) {
		PublishingCompany result = publishingCompanyRepository.findById(id).get();
		return result;
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public List<PublishingCompany> findAll(){
		List<PublishingCompany> result = publishingCompanyRepository.findAll();
		return result;
	}
	
}
