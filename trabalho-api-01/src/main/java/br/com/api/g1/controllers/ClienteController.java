package br.com.api.g1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g1.dto.ClienteAtualizarDTO;
import br.com.api.g1.dto.ClienteDTO;
import br.com.api.g1.dto.MessageResponseDTO;
import br.com.api.g1.entities.Cliente;
import br.com.api.g1.services.ClienteService;
import br.com.api.g1.services.EmailService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	private EmailService emailService;
	@Autowired
	ClienteService clienteService;

	@PostMapping("/salvarCliente")
	public ResponseEntity<MessageResponseDTO> salvarCliente(@RequestBody Cliente cliente) {
		clienteService.salvarCliente(cliente);
		return ResponseEntity.ok(new MessageResponseDTO("Novo cliente cadastrado!"));
	}

	@GetMapping("/listarClientes")
	public List<ClienteDTO> listarClientes() {
		return clienteService.listarClientes();
	}

	@GetMapping("/listarCliente/{id}")
	public Cliente listarIdCliente(@PathVariable Integer id) {
		return clienteService.listarIdCliente(id);
	}

	@DeleteMapping("/deletarCliente/{id}")
	public void deletarIdCliente(@PathVariable Integer id) {
		clienteService.deletarIdCliente(id);
		ResponseEntity.ok(new MessageResponseDTO("Cliente deletado!"));
	}

	@DeleteMapping("/desativarCliente/{id}")
	public void desativarCliente(@PathVariable Integer id) {
		emailService.envioEmailInativo();
		clienteService.desativarCliente(id);
		ResponseEntity.ok(new MessageResponseDTO("Cliente desativado!"));
	}

//	@PutMapping("/atualizarCliente/{id}")
//	public ResponseEntity<MessageResponseDTO> atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
//		 clienteService.atualizarCliente(id, cliente);
//		 return ResponseEntity.ok(new MessageResponseDTO("Cliente atualizado!"));
//	}

	@PostMapping ("/atualizarCliente/{id}")
	public ResponseEntity<MessageResponseDTO> atualizarCliente (@PathVariable Integer id, @RequestBody ClienteAtualizarDTO cliente) {
		clienteService.atualizarCliente (id, cliente); 
		return ResponseEntity.ok(new MessageResponseDTO ("Cliente atualizado!"));
	}

	@GetMapping("/clientes/clientePorCpf/{cpf}")
	public ClienteDTO listarClientesPorCPF(@RequestParam("cpf") String cpf) {
		return clienteService.listarClientesPorCPF(cpf);
	}

}
