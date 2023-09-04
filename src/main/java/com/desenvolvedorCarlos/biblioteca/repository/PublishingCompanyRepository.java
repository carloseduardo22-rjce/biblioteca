package com.desenvolvedorCarlos.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desenvolvedorCarlos.biblioteca.entities.PublishingCompany;

public interface PublishingCompanyRepository extends JpaRepository<PublishingCompany, Integer> {

}
