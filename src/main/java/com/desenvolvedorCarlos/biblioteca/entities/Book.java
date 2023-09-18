package com.desenvolvedorCarlos.biblioteca.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id")
	private PublishingCompany publishingCompany;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private CategoryBooks categoryBooks;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.REMOVE)
    private List<Loan> loans;
	
	public Book() {
	}

	public Book(Integer book_id, String titulo, Integer year, Integer quantidade_disponivel) {
		this.book_id = book_id;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public PublishingCompany getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(PublishingCompany publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	
	public CategoryBooks getCategoryBooks() {
		return categoryBooks;
	}

	public void setCategoryBooks(CategoryBooks categoryBooks) {
		this.categoryBooks = categoryBooks;
	}

	@Override
	public int hashCode() {
		return Objects.hash(book_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(book_id, other.book_id);
	}
	
}
