package br.com.api.g1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_categoria;
	private String nome;
	private String descricacao;
	
	public Categoria() {
		super();
	}

	public Categoria(Integer id_categoria, String nome, String descricacao) {
		super();
		this.id_categoria = id_categoria;
		this.nome = nome;
		this.descricacao = descricacao;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricacao() {
		return descricacao;
	}

	public void setDescricacao(String descricacao) {
		this.descricacao = descricacao;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", nome=" + nome + ", descricacao=" + descricacao + "]";
	}
	
	
}
