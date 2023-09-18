package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Book;
import com.desenvolvedorCarlos.biblioteca.repository.BookRepository;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Transactional(readOnly = true)
	public Book findById(Integer id) {
		Optional<Book> obj = bookRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Book not found!"));
	}
	
	@Transactional(readOnly = true)
	public List<Book> findAll(){
		List<Book> result = bookRepository.findAll();
		return result;
	}
	
	public Book insert(Book obj) {
		return bookRepository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		bookRepository.deleteById(id);
	}
	
}
