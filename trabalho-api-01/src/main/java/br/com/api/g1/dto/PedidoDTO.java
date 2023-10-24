package br.com.api.g1.dto;

import java.util.Date;
import java.util.List;

public class PedidoDTO {
		
		private String nome_cliente;
		private Integer id_cliente;
		private Integer id_pedido;
		private Date dataPedido;
//		private String produto_nome;
//		private String produto_descricao;
//		private Double vlr_uni;
		private List<Integer> id_produtos;
		
		public PedidoDTO(String nome_cliente,Integer id_cliente, Integer id_pedido, Date dataPedido) {
			super();
			this.nome_cliente = nome_cliente;
			this.id_cliente = id_cliente;
			this.id_pedido = id_pedido;
			this.dataPedido = dataPedido;
//			this.produto_nome = produto_nome;
//			this.produto_descricao = produto_descricao;
//			this.vlr_uni = vlr_uni;
		}

		public PedidoDTO() {
			super();
		}

		public String getNome_cliente() {
			return nome_cliente;
		}

		public void setNome_cliente(String nome_cliente) {
			this.nome_cliente = nome_cliente;
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
		
		public Integer getId_cliente() {
			return id_cliente;
		}

		public void setId_cliente(Integer id_cliente) {
			this.id_cliente = id_cliente;
		}
		
		public List<Integer> getId_produtos() {
			return id_produtos;
		}

		public void setId_produtos(List<Integer> id_produtos) {
			this.id_produtos = id_produtos;
		}

			
}
