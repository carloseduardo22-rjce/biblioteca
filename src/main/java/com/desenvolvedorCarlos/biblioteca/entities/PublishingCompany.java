package com.desenvolvedorCarlos.biblioteca.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "table_publishing_company")
public class PublishingCompany {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer publisher_id;
	private String name;
	private String address;
	private String telephone;
	
	public PublishingCompany() {
	}

	public PublishingCompany(Integer publisher_id, String name, String address, String telephone) {
		this.publisher_id = publisher_id;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}

	public Integer getPublisher_id() {
		return publisher_id;
	}

	public void setPublisher_id(Integer publisher_id) {
		this.publisher_id = publisher_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(publisher_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PublishingCompany other = (PublishingCompany) obj;
		return Objects.equals(publisher_id, other.publisher_id);
	}
	
}
