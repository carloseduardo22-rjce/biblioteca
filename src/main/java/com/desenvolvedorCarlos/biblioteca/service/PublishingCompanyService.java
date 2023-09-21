package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Book;
import com.desenvolvedorCarlos.biblioteca.entities.PublishingCompany;
import com.desenvolvedorCarlos.biblioteca.repository.BookRepository;
import com.desenvolvedorCarlos.biblioteca.repository.PublishingCompanyRepository;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;

@Service
public class PublishingCompanyService {

	@Autowired
	private PublishingCompanyRepository publishingCompanyRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional(readOnly = true)
	public PublishingCompany findById(Integer id) {
		Optional<PublishingCompany> obj = publishingCompanyRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("PublishingCompany not found!"));
	}
	
	@Transactional(readOnly = true)
	public List<PublishingCompany> findAll(){
		List<PublishingCompany> result = publishingCompanyRepository.findAll();
		return result;
	}

	public PublishingCompany insert(PublishingCompany publishingCompanyObj) {
		return publishingCompanyRepository.save(publishingCompanyObj);
	}

	public void removePublishingCompany(Integer id) {
		Optional<PublishingCompany> publishingCompanyOptional = publishingCompanyRepository.findById(id);
		
		if (publishingCompanyOptional.isPresent()) {
			PublishingCompany publishingCompany = publishingCompanyOptional.get();
			List<Book> books = bookRepository.findByPublishingCompany(publishingCompany);
			for (Book book : books) {
				book.setPublishingCompany(null);
			}
			publishingCompanyRepository.delete(publishingCompany);
		}
	}
	
}
