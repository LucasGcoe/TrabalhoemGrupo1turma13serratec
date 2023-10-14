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

import br.com.api.g1.entities.Categoria;
import br.com.api.g1.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {


	
	@Autowired
	CategoriaService categoriaService;
	
	@PostMapping("/salvarCategoria")
	public Categoria salvarCategoria(@RequestBody Categoria categoria) {
		return categoriaService.salvarCategoria(categoria);
	}
	
	@GetMapping("/listarCategorias")
	public List<Categoria> listarCategorias() {
		return categoriaService.listarCategorias();
	}

	@GetMapping("/listarCategoria/{id}")
	public Categoria listarIdCategoria(@PathVariable Integer id) {
		return categoriaService.listarIdCategoria(id);
	}
	
	@DeleteMapping("/deletarCategoria/{id}")
	public void deletarIdCategoria(@PathVariable Integer id) {
		categoriaService.deletarIdCategoria(id);
	}
	
}
