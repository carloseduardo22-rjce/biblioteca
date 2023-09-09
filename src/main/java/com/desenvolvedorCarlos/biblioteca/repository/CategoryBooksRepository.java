package com.desenvolvedorCarlos.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvedorCarlos.biblioteca.entities.CategoryBooks;

public interface CategoryBooksRepository extends JpaRepository<CategoryBooks, Integer> {

}
