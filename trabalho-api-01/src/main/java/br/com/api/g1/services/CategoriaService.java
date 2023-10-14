package br.com.api.g1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void desativarCategoria(Integer id) {
		Categoria categoria = listarIdCategoria(id);

		if (categoria != null) {
			categoria.setAtivo(false);
			categoriaRepository.save(categoria);
		}
	}

	public Categoria atualizarCategoria(Integer id, Categoria categoria) {
		Categoria dadoAntigo = listarIdCategoria(id);

		 if (categoria.getAtivo() != null) {
		 dadoAntigo.setAtivo(categoria.getAtivo());
		 }

		if (categoria.getNome() != null) {
			dadoAntigo.setNome(categoria.getNome());
		}
		if (categoria.getDescricao() != null) {
			dadoAntigo.setDescricao(categoria.getDescricao());
		}

		dadoAntigo.setId_categoria(id);
		return categoriaRepository.save(dadoAntigo);
	}
}