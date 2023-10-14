package br.com.api.g1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.api.g1.entities.Categoria;
import br.com.api.g1.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria salvarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}
	public Categoria listarIdCategoria(Integer id) {
		return categoriaRepository.findById(id).get();
	}
	
	public void deletarIdCategoria(Integer id) {
		categoriaRepository.deleteById(id);
	}
}
