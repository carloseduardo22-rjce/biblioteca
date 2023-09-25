package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Book;
import com.desenvolvedorCarlos.biblioteca.entities.Loan;
import com.desenvolvedorCarlos.biblioteca.repository.BookRepository;
import com.desenvolvedorCarlos.biblioteca.repository.LoanRepository;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
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
	
	public void removeBook(Integer bookId) {
		Optional<Book> bookOptional = bookRepository.findById(bookId);
		
		if (bookOptional.isPresent()) {
			Book book = bookOptional.get();
			List<Loan> loans = loanRepository.findByBook(book);
			for(Loan loan : loans) {
				loan.setBook(null);
			}
			bookRepository.delete(book);
		}
		
	}

	public void update(Integer id, Book book) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		
		if (bookOptional.isPresent()) {
			Book bookExisting = bookOptional.get();
			bookExisting.setTitle(book.getTitle());
			bookExisting.setYear(book.getYear());
			bookExisting.setAvailable_quantity(book.getAvailable_quantity());
			bookExisting.setAuthor(book.getAuthor());
			bookExisting.setPublishingCompany(book.getPublishingCompany());
			bookExisting.setCategoryBooks(book.getCategoryBooks());
			bookRepository.save(bookExisting);
		}
	}
	
}
