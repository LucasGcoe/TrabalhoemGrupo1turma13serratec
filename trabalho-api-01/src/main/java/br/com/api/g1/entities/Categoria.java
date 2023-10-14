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
	private String descricao;
	private Boolean ativo;
	
	public Categoria() {
		super();
	}

	public Categoria(Integer id_categoria, String nome, String descricacao, Boolean ativo) {
		super();
		this.id_categoria = id_categoria;
		this.nome = nome;
		this.descricao = descricacao;
		this.ativo = ativo;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricacao) {
		this.descricao = descricacao;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", nome=" + nome + ", descricao=" + descricao + ", ativo="
				+ ativo + "]";
	}
}
