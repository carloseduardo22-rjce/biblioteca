package com.desenvolvedorCarlos.biblioteca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer book_id;
	private String title;
	
	@Column(name = "livro_year")
	private Integer year;
	private Integer available_quantity;
	
	public Book() {
	}

	public Book(Integer livro_id, String titulo, Integer year, Integer quantidade_disponivel) {
		this.book_id = livro_id;
		this.title = titulo;
		this.year = year;
		this.available_quantity = quantidade_disponivel;
	}

	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getAvailable_quantity() {
		return available_quantity;
	}

	public void setAvailable_quantity(Integer available_quantity) {
		this.available_quantity = available_quantity;
	}
	
}
