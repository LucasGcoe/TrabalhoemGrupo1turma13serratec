package br.com.api.g1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
	public void desativarProduto(Integer id) {
		Produto produto = listarIdProdutos(id);
		if (produto!= null) {
			produto.setAtivo(false);
			produtoRepository.save(produto);
		}
	}
	public Produto atualizarProduto(Integer id, Produto produto) {
		Produto dadoAntigo = listarIdProdutos(id);
		if (produto.getNome()!=null) {
			dadoAntigo.setNome(produto.getNome());
		}
		if (produto.getDescricao()!=null) {
			dadoAntigo.setDescricao(produto.getDescricao());
		}
		if (produto.getDataFabricacao()!=null) {
			dadoAntigo.setDataFabricacao(produto.getDataFabricacao());
		}
		if (produto.getQtdEstoque()!=null) {
			dadoAntigo.setQtdEstoque(produto.getQtdEstoque());
		}
		if (produto.getVlrUnitario()!=null) {
			dadoAntigo.setVlrUnitario(produto.getVlrUnitario());
		}
		
		dadoAntigo.setId_produto(id);
		return produtoRepository.save(dadoAntigo);
	}
}
