package br.com.api.g1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.g1.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired 
	ProdutoRepository produtoRepository;
}
