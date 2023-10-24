package br.com.api.g1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.g1.dto.MessageResponseDTO;
import br.com.api.g1.dto.PedidoDTO;
import br.com.api.g1.entities.Cliente;
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
	
	@Autowired
	UserService userService;
	
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
		pedidoConvertido.setId_cliente(pedido.getCliente().getId_cliente());
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

		
	public ResponseEntity<MessageResponseDTO> salvarPedido(PedidoDTO pedidoDTO) {
		Pedido p = new Pedido(); 
				
		p.setId_pedido(pedidoDTO.getId_pedido());
		p.setDataPedido(pedidoDTO.getDataPedido());
		
		List<Produto> produtos = new ArrayList<>();
		for(Integer idProduto : pedidoDTO.getId_produtos()) {
			Produto produto = produtoRepository.findById(idProduto).get();
			produtos.add(produto);
			
		}
		p.setProdutos(produtos);
		Cliente cliente = clienteService.findById_cliente(pedidoDTO.getId_cliente());
		p.setCliente(cliente);
		pedidoRepository.save(p);
		return ResponseEntity.ok(new MessageResponseDTO("Novo pedido criado com sucesso!"));
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








