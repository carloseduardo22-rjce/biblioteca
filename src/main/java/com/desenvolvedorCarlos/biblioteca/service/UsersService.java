package com.desenvolvedorCarlos.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desenvolvedorCarlos.biblioteca.entities.Loan;
import com.desenvolvedorCarlos.biblioteca.entities.Users;
import com.desenvolvedorCarlos.biblioteca.repository.LoanRepository;
import com.desenvolvedorCarlos.biblioteca.repository.UsersRepository;
import com.desenvolvedorCarlos.biblioteca.service.exception.ObjectNotFoundException;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private LoanRepository loanRepository;
	
	@Transactional(readOnly = true)
	public Users findById(Integer id) {
		Optional<Users> obj = usersRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("User not found!"));
	}
	
	@Transactional(readOnly = true)
	public List<Users> findAll(){
		List<Users> result = usersRepository.findAll();
		return result;
	}

	public Users insert(Users usersObj) {
		return usersRepository.save(usersObj);
	}

	public void removeUser(Integer id) {
		Optional<Users> userOptional = usersRepository.findById(id);
		
		if (userOptional.isPresent()) {
			Users user = userOptional.get();
			List<Loan> loans = loanRepository.findByUser(user);
			for (Loan loan : loans) {
				loan.setUser(null);
			}
			usersRepository.delete(user);
		}
	}

	public void update(Integer id, Users user) {
		Optional<Users> userOptional = usersRepository.findById(id);
		
		if (userOptional.isPresent()) {
			Users userExisting = userOptional.get();
			userExisting.setName(user.getName());
			userExisting.setBirth_Date(user.getBirth_Date());
			userExisting.setAddress(user.getAddress());
			userExisting.setEmail(user.getEmail());
			usersRepository.save(user);
		}
	
	}
	
}
