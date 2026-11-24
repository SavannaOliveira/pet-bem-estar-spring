package br.edu.ifrs.petbemestar.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.petbemestar.dao.ClienteDAO;
import br.edu.ifrs.petbemestar.dominio.Cliente;


@RestController
public class ClienteController{
	
	private final ClienteDAO dao;
	
	public ClienteController(ClienteDAO dao) {
	this.dao = dao;
	
	}
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
	return dao.listarTodos();
	}


}
