package br.com.api.g1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g1.entities.Pedido;
import br.com.api.g1.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	public Pedido salvarPedido(Pedido pedido) {
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








