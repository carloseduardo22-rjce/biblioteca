package com.desenvolvedorCarlos.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvedorCarlos.biblioteca.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
