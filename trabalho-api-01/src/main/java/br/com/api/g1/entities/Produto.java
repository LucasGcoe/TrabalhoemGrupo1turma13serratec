package br.com.api.g1.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")

public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_produto;
	private String nome;
	private String descricao;
	private Date dataFabricacao;
	private Integer qtdEstoque;
	private Double vlrUnitario;
	private Boolean ativo;
	
	public Produto() {
		super();
	}

	public Produto(Integer id_produto, String nome, String descricao, Date dataFabricacao, Integer qtdEstoque,
			Double vlrUnitario, Boolean ativo) {
		super();
		this.id_produto = id_produto;
		this.nome = nome;
		this.descricao = descricao;
		this.dataFabricacao = dataFabricacao;
		this.qtdEstoque = qtdEstoque;
		this.vlrUnitario = vlrUnitario;
		this.ativo = ativo;
	}

	public Integer getId_produto() {
		return id_produto;
	}

	public void setId_produto(Integer id_produto) {
		this.id_produto = id_produto;
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

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Double getVlrUnitario() {
		return vlrUnitario;
	}

	public void setVlrUnitario(Double vlrUnitario) {
		this.vlrUnitario = vlrUnitario;
	}
	
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Produto [id_produto=" + id_produto + ", nome=" + nome + ", descricao=" + descricao + ", dataFabricacao="
				+ dataFabricacao + ", qtdEstoque=" + qtdEstoque + ", vlrUnitario=" + vlrUnitario + ", ativo=" + ativo
				+ "]";
	}

	
	
	

}
