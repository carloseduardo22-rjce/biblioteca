package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.CategoryBooks;
import com.desenvolvedorCarlos.biblioteca.repository.CategoryBooksRepository;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;

@Service
public class CategoryBooksService {

	@Autowired
	private CategoryBooksRepository categoryBooksRepository;
	
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
	
}