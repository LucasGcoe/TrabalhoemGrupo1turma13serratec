package br.com.api.g1.dto;

import java.util.Date;

public class PedidoDTO {
		
		private String nome_cliente;
		private String cpf;
		private Integer id_pedido;
		private Date dataPedido;
		private String produto_nome;
		private String produto_descricao;
		private Double vlr_uni;
		
		public PedidoDTO(String nome_cliente,String cpf, Integer id_pedido, Date dataPedido, String produto_nome,
				String produto_descricao, Double vlr_uni) {
			super();
			this.nome_cliente = nome_cliente;
			this.cpf = cpf;
			this.id_pedido = id_pedido;
			this.dataPedido = dataPedido;
			this.produto_nome = produto_nome;
			this.produto_descricao = produto_descricao;
			this.vlr_uni = vlr_uni;
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

		public String getProduto_nome() {
			return produto_nome;
		}

		public void setProduto_nome(String produto_nome) {
			this.produto_nome = produto_nome;
		}

		public String getProduto_descricao() {
			return produto_descricao;
		}

		public void setProduto_descricao(String produto_descricao) {
			this.produto_descricao = produto_descricao;
		}

		public Double getVlr_uni() {
			return vlr_uni;
		}

		public void setVlr_uni(Double vlr_uni) {
			this.vlr_uni = vlr_uni;
		}
		
		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		@Override
		public String toString() {
			return "PedidoDTO [nome_cliente=" + nome_cliente + ", cpf=" + cpf + ", id_pedido=" + id_pedido
					+ ", dataPedido=" + dataPedido + ", produto_nome=" + produto_nome + ", produto_descricao="
					+ produto_descricao + ", vlr_uni=" + vlr_uni + "]";
		}

			
}
