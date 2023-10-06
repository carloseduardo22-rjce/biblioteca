package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Loan;
import com.desenvolvedorCarlos.biblioteca.repository.LoanRepository;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loansRepository;
	
	@Transactional(readOnly = true)
	public Loan findById (Integer id) {
		Optional<Loan> obj = loansRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Loan not found!"));
	}
	
	@Transactional(readOnly = true)
	public List<Loan> findAll() {
		List<Loan> result = loansRepository.findAll();
		return result;
	}
	
	public Loan insert(Loan loanObj) {
		return loansRepository.save(loanObj);
	}

	public void removeLoan(Integer id) {
		Optional<Loan> loanOptional = loansRepository.findById(id);
		
		if (!loanOptional.isPresent()) {
			throw new ObjectNotFoundException("Loan object not found!");
		}
		else {
			Loan loan = loanOptional.get();
			loan.setBook(null);
			loan.setUser(null);
			loansRepository.delete(loan);
		}
	}

	public void update(Integer id, Loan loan) {
		Optional<Loan> loanOptional = loansRepository.findById(id);
		
		if (loanOptional.isPresent()) {
			Loan loanExisting = loanOptional.get();
			loanExisting.setLoan_date(loan.getLoan_date());
			loanExisting.setReturn_date(loan.getReturn_date());
			loanExisting.setUser(loan.getUser());
			loanExisting.setBook(loan.getBook());
			loansRepository.save(loanExisting);
		}

	}
	
}
