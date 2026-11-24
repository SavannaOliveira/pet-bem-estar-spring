package br.edu.ifrs.petbemestar.web;
import br.edu.ifrs.petbemestar.dao.*;

import br.edu.ifrs.petbemestar.dominio.Cliente;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientePaginaController{
	

	private final ClienteDAO dao;
	public ClientePaginaController(ClienteDAO dao) {
	this.dao = dao;
	}
	
	@GetMapping("/paginas/clientes")
	public String listar(Model model) {
    model.addAttribute("clientes", dao.listarTodos());
	return "clientes/lista";
	}	
	
	@GetMapping("/paginas/clientes/nova")
	public String formulario(Model model) {
	model.addAttribute("cliente", new Cliente());
	return "clientes/formulario";
	}
	
	@PostMapping("/paginas/clientes/nova")
	public String cadastrar(@Valid @ModelAttribute Cliente cliente, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "clientes/formulario";
		}
		dao.salvar(cliente);
			return "redirect:/paginas/clientes";
	}
	
	@GetMapping("/paginas/clientes/{id}/editar")
	public String edicao(@PathVariable Long id, Model model) {
	model.addAttribute("cliente", dao.buscarPorId(id));
	return "clientes/editar";
	}
	
	@PostMapping("/paginas/clientes/editar")
	public String atualizar(@Valid @ModelAttribute Cliente cliente, BindingResult resultado) {
		
		if (resultado.hasErrors()) {
			return "clientes/editar";
			}
			dao.atualizar(cliente);
			return "redirect:/paginas/clientes";
			
	
	}
	
	@PostMapping("/paginas/clientes/{id}/remover")
	public String remover(@PathVariable Long id) {
	dao.remover(id);
	return "redirect:/paginas/clientes";
	}
	

}
