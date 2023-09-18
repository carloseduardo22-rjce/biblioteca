package com.desenvolvedorCarlos.biblioteca.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_author")
public class Author {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer author_id;
	
	private String name;
	private Date birth_date;
	private String country;
	
	public Author() {
	}

	public Author(Integer author_id, String name, Date birth_date, String country) {
		this.author_id = author_id;
		this.name = name;
		this.birth_date = birth_date;
		this.country = country;
	}

	public Integer getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Integer author_id) {
		this.author_id = author_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(author_id, other.author_id);
	}
	
}
