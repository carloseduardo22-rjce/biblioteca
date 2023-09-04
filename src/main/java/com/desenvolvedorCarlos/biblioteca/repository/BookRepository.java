package com.desenvolvedorCarlos.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvedorCarlos.biblioteca.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
