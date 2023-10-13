package br.com.api.g1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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



}
