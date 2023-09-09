package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Loan;
import com.desenvolvedorCarlos.biblioteca.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loansRepository;
	
	@Transactional(readOnly = true)
	public Loan findById (Integer id) {
		Loan result = loansRepository.findById(id).get();
		return result;
	}
	
	@Transactional(readOnly = true)
	public List<Loan> findAll() {
		List<Loan> result = loansRepository.findAll();
		return result;
	}
	
}
