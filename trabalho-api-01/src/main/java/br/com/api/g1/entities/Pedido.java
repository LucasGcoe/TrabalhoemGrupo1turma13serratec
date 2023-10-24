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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Integer id_pedido; 
	@Column(name = "dataPedido_pedido")
	@NotNull 
	private Date dataPedido;
	@Column(name = "ativo")
	private Boolean ativo = true;
	
	@ManyToMany
	@JoinTable(
			name="pedido_produto",
			joinColumns=@JoinColumn(name="pedido_id"),
			inverseJoinColumns=@JoinColumn(name="produto_id")
			)
	private List<Produto> produtos;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente cliente;

	public Pedido() {
		super();
	}

	public Pedido(Integer id_pedido, @NotNull Date dataPedido, Boolean ativo, Cliente cliente) {
		super();
		this.id_pedido = id_pedido;
		this.dataPedido = dataPedido;
		this.ativo = ativo;
		this.cliente = cliente;
	}

	public Integer getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Integer id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
}
