package br.com.api.g1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.g1.services.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {


	
	@Autowired
	CategoriaService categoriaService;

}
