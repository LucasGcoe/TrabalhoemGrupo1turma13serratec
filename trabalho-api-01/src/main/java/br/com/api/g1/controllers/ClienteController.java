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

import br.com.api.g1.dto.ClienteDTO;
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
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}
	
	@GetMapping("/listarClientes")
	public List<ClienteDTO> listarClientes(){
		return clienteService.listarClientes();
	}
	
	@GetMapping("/listarCliente/{id}")
	public Cliente listarIdCliente(@PathVariable Integer id) {
		return clienteService.listarIdCliente(id);
	}
	
	@DeleteMapping("/deletarCliente/{id}")
	public void deletarIdCliente(@PathVariable Integer id) {
		clienteService.deletarIdCliente(id);
	}
	
	@DeleteMapping("/desativarCliente/{id}")
	public void desativarCliente(@PathVariable Integer id) {
		emailService.envioEmailInativo();
		clienteService.desativarCliente(id);
	}
			
	@PutMapping("/atualizarCliente/{id}")
	public Cliente atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
		return clienteService.atualizarCliente(id, cliente);
	}

}
