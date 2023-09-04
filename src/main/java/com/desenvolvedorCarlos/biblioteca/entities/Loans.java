package com.desenvolvedorCarlos.biblioteca.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_loans")
public class Loans {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loan_id;
	private Date loan_date;
	private Date return_date;
	
	public Loans() {
	}

	public Loans(Integer loan_id, Date loan_date, Date return_date) {
		this.loan_id = loan_id;
		this.loan_date = loan_date;
		this.return_date = return_date;
	}

	public Integer getLoan_id() {
		return loan_id;
	}

	public void setLoan_id(Integer loan_id) {
		this.loan_id = loan_id;
	}

	public Date getLoan_date() {
		return loan_date;
	}

	public void setLoan_date(Date loan_date) {
		this.loan_date = loan_date;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(loan_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loans other = (Loans) obj;
		return Objects.equals(loan_id, other.loan_id);
	}
	
}
