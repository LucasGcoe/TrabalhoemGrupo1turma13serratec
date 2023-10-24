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
import br.com.api.g1.entities.Produto;
import br.com.api.g1.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@PostMapping("/salvarProduto")
	public ResponseEntity<MessageResponseDTO> salvarProduto(@RequestBody Produto produto) {
		produtoService.salvarProduto(produto);
		return ResponseEntity.ok(new MessageResponseDTO("Produto cadastrado com sucesso!"));
	}

	@GetMapping("/listarProdutos")
	public List<Produto> listarProdutos() {
		return produtoService.listarProdutos();
	}

	@GetMapping("/listarIdProdutos/{id}")
	public Produto listarIdProdutos(@PathVariable Integer id) {
		return produtoService.listarIdProdutos(id);
	}

	@DeleteMapping("/deletarIdProdutos/{id}")
	public void deletarIdProdutos(@PathVariable Integer id) {
		produtoService.deletarIdProdutos(id);
		ResponseEntity.ok(new MessageResponseDTO("Produto deletado com sucesso!"));
	}

	@DeleteMapping("/desativarProduto/{id}")
	public void desativarProduto(@PathVariable Integer id) {
		produtoService.desativarProduto(id);
		ResponseEntity.ok(new MessageResponseDTO("Produto desativado com sucesso!"));
	}

	@PutMapping("/atualizarProduto/{id}")
	public ResponseEntity<MessageResponseDTO> atualizarProduto(@PathVariable Integer id, @RequestBody Produto produto) {
		 produtoService.atualizarProduto(id, produto);
		 return ResponseEntity.ok(new MessageResponseDTO("Produto atualizado com sucesso!"));
	}
}