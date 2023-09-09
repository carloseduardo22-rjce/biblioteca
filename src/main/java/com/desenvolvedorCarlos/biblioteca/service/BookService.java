package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Book;
import com.desenvolvedorCarlos.biblioteca.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Transactional(readOnly = true)
	public Book findById(Integer id) {
		Book result = bookRepository.findById(id).get();
		return result;
	}
	
	@Transactional(readOnly = true)
	public List<Book> findAll(){
		List<Book> result = bookRepository.findAll();
		return result;
	}
	
}
