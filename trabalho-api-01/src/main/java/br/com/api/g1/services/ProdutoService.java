package br.com.api.g1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.api.g1.entities.Produto;
import br.com.api.g1.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired 
	ProdutoRepository produtoRepository;
	
	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public List<Produto> listarProdutos(){
		return produtoRepository.findAll();
	}

	public Produto listarIdProdutos(Integer id) {
		return produtoRepository.findById(id).get();
	}
	
	public void deletarIdProdutos(Integer id) {
		produtoRepository.deleteById(id);
	}
}
