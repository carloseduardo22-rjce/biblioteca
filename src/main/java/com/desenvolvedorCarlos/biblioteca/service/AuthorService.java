package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Author;
import com.desenvolvedorCarlos.biblioteca.entities.Book;
import com.desenvolvedorCarlos.biblioteca.repository.AuthorRepository;
import com.desenvolvedorCarlos.biblioteca.repository.BookRepository;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired 
	private BookRepository bookRepository;
	
	@Transactional(readOnly = true)
	public Author findById(Integer id) {
		Optional<Author> obj = authorRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Author not found!"));
	}
	
	@Transactional(readOnly = true)
	public List<Author> findAll() {
		List<Author> result = authorRepository.findAll();
		return result;
	}
	
	public Author insert(Author obj) {
		return authorRepository.save(obj);
	}
	
	public void remove(Integer authorId) {
		Optional<Author> authorOptional = authorRepository.findById(authorId);
		
		if (!authorOptional.isPresent()) {
			throw new ObjectNotFoundException("Author object not found!");
		}
		else {
			Author author = authorOptional.get();
			List<Book> books = bookRepository.findByAuthor(author);
			for(Book book : books) {
				book.setAuthor(null);
			}
			authorRepository.delete(author);
		}
		
	}

	public void update(Integer id, Author author) {
		Optional<Author> authorOptional = authorRepository.findById(id);
		
		if (authorOptional.isPresent()) {
			Author authorExisting = authorOptional.get();
			authorExisting.setName(author.getName());
			authorExisting.setBirth_date(author.getBirth_date());
			authorExisting.setCountry(author.getCountry());
			authorRepository.save(authorExisting);
		}

	}
	
}
