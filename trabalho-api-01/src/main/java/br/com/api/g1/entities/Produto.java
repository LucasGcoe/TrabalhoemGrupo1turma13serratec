package br.com.api.g1.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produto")

public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Integer id_produto;//depois colocar em CammelCase
	@Column(name = "nome_produto")
	@NotNull 
	@Size(max=50)
	private String nome;
	@Column(name = "descricao_produto")
	@NotNull 
	@Size(max=120)
	private String descricao;
	@Column(name = "dataFabricacao_produto")
	@NotNull 
	private Date dataFabricacao;
	@Column(name = "qtdEstoque_produto")
	@NotNull 
	
	private Integer qtdEstoque;
	@Column(name = "vlrUnitario_produto")
	@NotNull 
	
	private Double vlrUnitario;
	@Column(name = "ativo")
	private Boolean ativo;
	
	@OneToMany
	@JoinColumn(name = "produto_id")
	private List<Categoria> categorias;
	
	@ManyToMany
	@JoinTable(
			name="produto_pedido",
			joinColumns=@JoinColumn(name="produto_id"),
			inverseJoinColumns=@JoinColumn(name="pedido_id")
			)
	private List<Pedido> pedidos;
	
	public Produto() {
		super();
	}

	public Produto(Integer id_produto, @NotNull @Size(max = 50) String nome, @NotNull @Size(max = 120) String descricao,
			@NotNull Date dataFabricacao, @NotNull Integer qtdEstoque,
			@NotNull Double vlrUnitario, Boolean ativo, List<Categoria> categorias,
			List<Pedido> pedidos) {
		super();
		this.id_produto = id_produto;
		this.nome = nome;
		this.descricao = descricao;
		this.dataFabricacao = dataFabricacao;
		this.qtdEstoque = qtdEstoque;
		this.vlrUnitario = vlrUnitario;
		this.ativo = ativo;
		this.categorias = categorias;
		this.pedidos = pedidos;
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
