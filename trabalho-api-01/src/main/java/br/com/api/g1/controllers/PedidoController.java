package br.com.api.g1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g1.entities.Pedido;
import br.com.api.g1.services.EmailService;
import br.com.api.g1.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	private EmailService emailService; //EM TODOS OS CONTROLES QUE TIVER DISPARO DE EMAIL DEVE TER !!!!
	 @Autowired
	    public void setEmailService(EmailService emailService) {
	        this.emailService = emailService;
	    }
	 
	@Autowired
	PedidoService pedidoService;
	
	@PostMapping("/salvarPedido") 
	public Pedido salvarPedido(@RequestBody Pedido pedido) {
		emailService.envioEmailPedidoRealizado();
		return pedidoService.salvarPedido(pedido);		
	}
	
	@GetMapping("/listarPedidos")
	public List<Pedido> listarPedidos() {
		return pedidoService.listarPedidos();
	}
	
	@GetMapping("/listarIdPedido/{id}")
	public Pedido listarIdPedido(@PathVariable Integer id) {
		return pedidoService.listarIdPedido(id);
	}
	
	@DeleteMapping("/deletarIdPedido/{id}")
	public void deletarIdPedido(@PathVariable Integer id) {
		emailService.envioEmailPedidoCancel();
		pedidoService.deletarIdPedido(id);
	}
	
	@DeleteMapping("/desativarPedido/{id}")
	public void desativarPedido(@PathVariable Integer id) {
		pedidoService.desativarPedido(id);
	}
	
	@PutMapping("/atualizarPedido/{id}")
	public Pedido atualizaPedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
		return pedidoService.atualizarPedido(id, pedido);
	}
	
	
	
}

	