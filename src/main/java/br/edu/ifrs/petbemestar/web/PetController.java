package br.edu.ifrs.petbemestar.web;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.petbemestar.dao.PetDAO;
import br.edu.ifrs.petbemestar.dominio.Pet;

@RestController
public class PetController {
	
	private final PetDAO dao;
	
	public PetController(PetDAO dao) {
	this.dao = dao;
	
	}
	
	@GetMapping("/pets")
	public List<Pet> listar() {
	return dao.listarTodos();
	}

}
