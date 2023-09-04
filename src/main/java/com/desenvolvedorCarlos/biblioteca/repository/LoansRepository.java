package com.desenvolvedorCarlos.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvedorCarlos.biblioteca.entities.Loans;

public interface LoansRepository extends JpaRepository<Loans, Integer>{

}
