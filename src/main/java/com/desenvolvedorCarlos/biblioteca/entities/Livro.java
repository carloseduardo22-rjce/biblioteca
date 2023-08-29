package com.desenvolvedorCarlos.biblioteca.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer livro_id;
	private String titulo;
	
	@Column(name = "livro_year")
	private Integer year;
	private Integer quantidade_disponivel;
	
	public Livro() {
	}

	public Livro(Integer livro_id, String titulo, Integer year, Integer quantidade_disponivel) {
		this.livro_id = livro_id;
		this.titulo = titulo;
		this.year = year;
		this.quantidade_disponivel = quantidade_disponivel;
	}

	public Integer getLivro_id() {
		return livro_id;
	}

	public void setLivro_id(Integer livro_id) {
		this.livro_id = livro_id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAno_publicacao() {
		return year;
	}

	public void setAno_publicacao(Integer year) {
		this.year = year;
	}

	public Integer getQuantidade_disponivel() {
		return quantidade_disponivel;
	}

	public void setQuantidade_disponivel(Integer quantidade_disponivel) {
		this.quantidade_disponivel = quantidade_disponivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(livro_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(livro_id, other.livro_id);
	}
	
}
