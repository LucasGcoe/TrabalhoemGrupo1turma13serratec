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
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g1.dto.MessageResponseDTO;
import br.com.api.g1.entities.Funcionario;
import br.com.api.g1.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@PostMapping("/salvarFuncionario")
	public ResponseEntity<MessageResponseDTO> salvarFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioService.salvarFuncionario(funcionario);
		return ResponseEntity.ok(new MessageResponseDTO("Novo funcionário criado!"));
		}		
	@GetMapping("/listarFuncionarios")
	public List<Funcionario> listarFuncionarios(){
		return funcionarioService.listarFuncionarios();
		
	}
	@GetMapping("/listarIdFuncionarios/{id}")
	public Funcionario listarIdFuncionario(@PathVariable Integer id) {
		return funcionarioService.listarIdFuncionario(id);
	}
	
	@DeleteMapping("/deletarIdFuncionarios/{id}")
	public void deletarIdFuncionario(@PathVariable Integer id) {
		funcionarioService.deletarIdFuncionario(id);
		ResponseEntity.ok(new MessageResponseDTO("Funcionário deletado!"));
	}
	
	@DeleteMapping("/desativarFuncionario/{id}")
	public void desativarFuncionario(@PathVariable Integer id) {
		funcionarioService.desativarFuncionario(id);
		ResponseEntity.ok(new MessageResponseDTO("Funcionário desativado!"));
	}
	
	
	@PutMapping("/atualizarFuncionario/{id}")
	public ResponseEntity<MessageResponseDTO> atualizarFuncionario(@PathVariable Integer id, @RequestBody Funcionario funcionario) {
		funcionarioService.atualizarFuncionario(id,funcionario);
		return ResponseEntity.ok(new MessageResponseDTO("Funcionário deletado!"));
	}
	
}
