package br.com.api.g1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.g1.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	
}
