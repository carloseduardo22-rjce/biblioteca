package com.desenvolvedorCarlos.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvedorCarlos.biblioteca.entities.Author;
import com.desenvolvedorCarlos.biblioteca.entities.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByAuthor(Author author);
}
