package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.CategoryBooks;
import com.desenvolvedorCarlos.biblioteca.repository.CategoryBooksRepository;

@Service
public class CategoryBooksService {

	@Autowired
	private CategoryBooksRepository categoryBooksRepository;
	
	@Transactional(readOnly = true)
	public CategoryBooks findById (Integer id) {
		CategoryBooks result = categoryBooksRepository.findById(id).get();
		return result;
	}
	
	@Transactional(readOnly = true)
	public List<CategoryBooks> findAll () {
		List<CategoryBooks> result = categoryBooksRepository.findAll();
		return result;
	}
	
}
