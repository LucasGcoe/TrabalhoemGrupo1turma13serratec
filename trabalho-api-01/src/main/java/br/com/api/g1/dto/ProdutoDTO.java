package br.com.api.g1.dto;


public class ProdutoDTO {

	private String nome;
	private String descricao;
	
	public ProdutoDTO() {
		super();
	}
	public ProdutoDTO(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
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
	
	
	
}
