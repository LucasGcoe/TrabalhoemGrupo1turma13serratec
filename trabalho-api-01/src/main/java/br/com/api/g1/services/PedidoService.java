package br.com.api.g1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g1.dto.PedidoDTO;
import br.com.api.g1.entities.Pedido;
import br.com.api.g1.entities.Produto;
import br.com.api.g1.repositories.ClienteRepository;
import br.com.api.g1.repositories.PedidoRepository;
import br.com.api.g1.repositories.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ClienteService clienteService;
	
//	public List<PedidoDTO> listarClientes() {
//
//		List<PedidoDTO> infoPedidos = new ArrayList<>();
//		List<Pedido> pedidos = pedidoRepository.findAll();
//		for (Pedido pedido : pedidos && Cliente cliente : clientes && Produto produto: produto) {
//			infoPedidos.add(converterPedidoDTO(cliente, pedido, produto));
//		}
//		return infoPedidos;

//	}

	public PedidoDTO converterPedidoDTO(Pedido pedido) {
		PedidoDTO pedidoConvertido = new PedidoDTO();
		pedidoConvertido.setId_pedido(pedido.getId_pedido());
		pedidoConvertido.setNome_cliente(pedido.getCliente().getUsuario());
		pedidoConvertido.setCpf(pedido.getCliente().getCpf());
		pedidoConvertido.setDataPedido(pedido.getDataPedido());
		
		List<Produto> produtos = new ArrayList<>();
		for(Integer id_produto : pedidoConvertido.getId_produtos()) {
			Produto produto = produtoRepository.findById(id_produto).get();
			produtos.add(produto);
		}
		pedido.setProdutos(produtos);
//		pedidoConvertido.setProduto_nome(pedido.getProdutos());
//		pedidoConvertido.setProduto_descricao(produto.getDescricao());
//		pedidoConvertido.setVlr_uni(produto.getVlrUnitario());
				
		return pedidoConvertido;
	}
	
//	public PedidoDTO listarPedidoPorCliente(String cpf, Integer id, Integer id_p) {
//		
//		Cliente cliente = clienteRepository.findByCpf(cpf);
//		Optional<Pedido> pedido = pedidoRepository.findById(id);
//		Optional<Produto> produto = produtoRespository.findById(id_p);
//		return converterPedidoDTO(cliente,pedido,produto);
//	}
	
	public Pedido salvarPedido(Pedido pedido) {
		converterPedidoDTO(pedido);
		return pedidoRepository.save(pedido);	
		
	}
	
	public List<Pedido> listarPedidos() {
		return pedidoRepository.findAll();		
	}	

	public Pedido listarIdPedido(Integer id) {
		return pedidoRepository.findById(id).get();
	}
	
	public void deletarIdPedido(Integer id) {
		pedidoRepository.deleteById(id);
	}
	
	public void desativarPedido(Integer id) {
        Pedido pedido = listarIdPedido(id);
        if (pedido!= null) {
            pedido.setAtivo(false);
            pedidoRepository.save(pedido);
        }        
	}
	
	public Pedido atualizarPedido(Integer id, Pedido pedido) {
		Pedido dadoAntigo = listarIdPedido(id);
		
		if(pedido.getAtivo()!=null) { 
			dadoAntigo.setAtivo(pedido.getAtivo());	
		}
		
		if(pedido.getDataPedido()!=null) {
			dadoAntigo.setDataPedido(pedido.getDataPedido());
		}
		
		dadoAntigo.setId_pedido(id);		
			return pedidoRepository.save(dadoAntigo);
	}
}








