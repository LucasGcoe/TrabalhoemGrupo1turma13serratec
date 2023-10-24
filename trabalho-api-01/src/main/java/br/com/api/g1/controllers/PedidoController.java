package br.com.api.g1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g1.dto.MessageResponseDTO;
import br.com.api.g1.dto.PedidoDTO;
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
	public ResponseEntity<MessageResponseDTO> salvarPedido(@RequestBody PedidoDTO pedidoDTO) {
		emailService.envioEmailPedidoRealizado();
		pedidoService.salvarPedido(pedidoDTO);	
		return ResponseEntity.ok(new MessageResponseDTO("Novo pedido criado com sucesso!"));
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
		ResponseEntity.ok(new MessageResponseDTO("Pedido deletado com sucesso!"));
	}
	
	@DeleteMapping("/desativarPedido/{id}")
	public void desativarPedido(@PathVariable Integer id) {
		pedidoService.desativarPedido(id);
		ResponseEntity.ok(new MessageResponseDTO("Pedido desativado com sucesso!"));
	}
	
	@PutMapping("/atualizarPedido/{id}")
	public ResponseEntity<MessageResponseDTO> atualizaPedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
		pedidoService.atualizarPedido(id, pedido);
		return ResponseEntity.ok(new MessageResponseDTO("Novo pedido criado com sucesso!"));
	}
	
	@GetMapping("/pedidos/pedidos")
	public PedidoDTO listarPedidoPorCliente(@RequestParam("cpf") String cpf) {
		return listarPedidoPorCliente(cpf);
		
	}
	
}

	