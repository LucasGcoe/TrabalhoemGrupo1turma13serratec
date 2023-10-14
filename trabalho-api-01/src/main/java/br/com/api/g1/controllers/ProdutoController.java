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

import br.com.api.g1.entities.Produto;
import br.com.api.g1.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@PostMapping("/salvarProduto")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoService.salvarProduto(produto);
	}
	@GetMapping("/listarProdutos")
	public List<Produto> listarProdutos(){
		return produtoService.listarProdutos();
	}

	@GetMapping("/listarIdProdutos/{id}")
	public Produto listarIdProdutos(@PathVariable Integer id) {
		return produtoService.listarIdProdutos(id);
	}
	
	@DeleteMapping("/deletarIdProdutos/{id}")
	public void deletarIdProdutos(@PathVariable Integer id) {
		produtoService.deletarIdProdutos(id);
	}
}
