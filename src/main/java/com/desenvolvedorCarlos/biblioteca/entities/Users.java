package com.desenvolvedorCarlos.biblioteca.entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	
	private String name;
	private Date birth_Date;
	private String address;
	private String email;
	
	public Users() {
	}

	public Users(Integer usuário_id, String name, Date birth_Date, String address, String email) {
		this.user_id = usuário_id;
		this.name = name;
		this.birth_Date = birth_Date;
		this.address = address;
		this.email = email;
	}

	public Integer getUsuário_id() {
		return user_id;
	}

	public void setUsuário_id(Integer usuário_id) {
		this.user_id = usuário_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth_Date() {
		return birth_Date;
	}

	public void setBirth_Date(Date birth_Date) {
		this.birth_Date = birth_Date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(user_id, other.user_id);
	}
	
}
