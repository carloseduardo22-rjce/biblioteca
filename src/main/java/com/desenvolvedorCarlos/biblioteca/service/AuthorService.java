package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Author;
import com.desenvolvedorCarlos.biblioteca.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Transactional(readOnly = true)
	public Author findById(Integer id) {
		Author result = authorRepository.findById(id).get();
		return result;
	}
	
	@Transactional(readOnly = true)
	public List<Author> findAll() {
		List<Author> result = authorRepository.findAll();
		return result;
	}
	
}
