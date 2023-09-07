package com.desenvolvedorCarlos.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvedorCarlos.biblioteca.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

}
