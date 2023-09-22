package com.desenvolvedorCarlos.biblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvedorCarlos.biblioteca.entities.Book;
import com.desenvolvedorCarlos.biblioteca.entities.Loan;
import com.desenvolvedorCarlos.biblioteca.entities.Users;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	List<Loan> findByBook(Book book);
	List<Loan> findByUser(Users user);
}
