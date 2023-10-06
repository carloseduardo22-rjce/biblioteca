package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Book;
import com.desenvolvedorCarlos.biblioteca.entities.CategoryBooks;
import com.desenvolvedorCarlos.biblioteca.repository.BookRepository;
import com.desenvolvedorCarlos.biblioteca.repository.CategoryBooksRepository;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;

@Service
public class CategoryBooksService {

	@Autowired
	private CategoryBooksRepository categoryBooksRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Transactional(readOnly = true)
	public CategoryBooks findById (Integer id) {
		Optional<CategoryBooks> obj = categoryBooksRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("CategoryBooks not found!"));
	}
	
	@Transactional(readOnly = true)
	public List<CategoryBooks> findAll () {
		List<CategoryBooks> result = categoryBooksRepository.findAll();
		return result;
	}
	
	public CategoryBooks insert(CategoryBooks categoryBooksObj) {
		return categoryBooksRepository.save(categoryBooksObj);
	}
	
	public void removeCategory(Integer categoryId) {
		Optional<CategoryBooks> categoryOptional = categoryBooksRepository.findById(categoryId);
		
		if (!categoryOptional.isPresent()) {
			throw new ObjectNotFoundException("CategoryBooks object not found!");
		}
		else {
			CategoryBooks categoryBook = categoryOptional.get();
			List<Book> books = bookRepository.findByCategoryBooks(categoryBook);
			for(Book book : books) {
				book.setCategoryBooks(null);
			}
			categoryBooksRepository.delete(categoryBook);
		}
		
	}

	public void update(Integer id, CategoryBooks categoryBooks) {
		Optional<CategoryBooks> categoryBookOptional = categoryBooksRepository.findById(id);
		
		if (!categoryBookOptional.isPresent()) {
			throw new ObjectNotFoundException("Category object not found!");
		}
		else {
			CategoryBooks categoryBookExisting = categoryBookOptional.get();
			categoryBookExisting.setCategory_name(categoryBooks.getCategory_name());
			categoryBookExisting.setDescription(categoryBooks.getDescription());
			categoryBookExisting.setBooks(categoryBooks.getBooks());
			categoryBooksRepository.save(categoryBookExisting);
		}
	
	}
	
}
