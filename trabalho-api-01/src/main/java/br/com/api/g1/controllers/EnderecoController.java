package br.com.api.g1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g1.dto.EnderecoDTO;
import br.com.api.g1.entities.Endereco;
import br.com.api.g1.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping("/salvarEndereco")
	public Endereco salvarEndereco(@RequestBody EnderecoDTO endereco) {
		return enderecoService.salvarEndereco(endereco);
	}
	
//	@GetMapping("/listarEnderecos")
//	public List<Endereco> listarEnderecos(){
//		return enderecoService.listarEndereco();
//	}
//	
//	@GetMapping("/listarEndereco/{id}")
//	public Cliente listarIdEndereco(@PathVariable Integer id) {
//		return enderecoService.listarIdEndereco(id);
//	}
//	
//	@DeleteMapping("/deletarEndereco/{id}")
//	public void deletarIdEndereco(@PathVariable Integer id) {
//		enderecoService.deletarIdEndereco(id);
//	}
//	
//	@DeleteMapping("/desativarEndereco/{id}")
//	public void desativarEndereco(@PathVariable Integer id) {
//		enderecoService.desativarEndereco(id);
//	}
//			
//	@PutMapping("/atualizarEndereco/{id}")
//	public Cliente atualizarEndereco(@PathVariable Integer id, @RequestBody Endereco endereco) {
//		return enderecoService.atualizarEndereco(id, endereco);
//	}
	
}
