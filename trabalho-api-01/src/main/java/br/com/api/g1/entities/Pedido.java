package br.com.api.g1.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	private Cliente Cliente;
	
	public Pedido() {
		super();
	}

	public Pedido(Integer id_pedido, @NotNull Date dataPedido, Boolean ativo) {
		super();
		this.id_pedido = id_pedido;
		this.dataPedido = dataPedido;
		this.ativo = ativo;
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

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", dataPedido=" + dataPedido + ", ativo=" + ativo + "]";
	}	
	
}
