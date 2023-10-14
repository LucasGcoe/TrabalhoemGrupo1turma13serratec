package br.com.api.g1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g1.entities.Cliente;
import br.com.api.g1.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping("/salvarCliente")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvarCliente(cliente);
	}
	
	@GetMapping("/listarClientes")
	public List<Cliente> listarClientes(){
		return clienteService.listarClientes();
	}
	
	@GetMapping("/listar/{id}")
	public Cliente listarIdCliente(@PathVariable Integer id) {
		return clienteService.listarIdCliente(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletarIdCliente(@PathVariable Integer id) {
		clienteService.deletarIdCliente(id);
	}
	

}
