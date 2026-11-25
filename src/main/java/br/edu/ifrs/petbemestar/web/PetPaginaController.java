package br.edu.ifrs.petbemestar.web;
import br.edu.ifrs.petbemestar.dao.*;
import br.edu.ifrs.petbemestar.dominio.Pet;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class PetPaginaController{
	
	private final ClienteDAO clienteDAO;
	private final PetDAO dao;
	
	public PetPaginaController(PetDAO dao , ClienteDAO clienteDAO) {
	this.dao = dao;
	this.clienteDAO = clienteDAO;
	}
	
	@GetMapping("/paginas/pets")
	public String listar(Model model) {
    model.addAttribute("pets", dao.listarTodos());
	return "pets/lista";
	}	
	
	@GetMapping("/paginas/pets/nova")
	public String formulario(Model model) {
		Pet pet = new Pet();
	model.addAttribute("pet",  pet);
	model.addAttribute("clientes", clienteDAO.listarTodos());
	return "pets/formulario";
	}
	
	@PostMapping("/paginas/pets/nova")
	public String cadastrar(@Valid @ModelAttribute Pet pet, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "pets/formulario";
		}
		dao.salvar(pet);
			return "redirect:/paginas/pets";
	}
	
	@GetMapping("/paginas/pets/{id}/editar")
	public String edicao(@PathVariable Long id, Model model) {
	model.addAttribute("pet", dao.buscarPorId(id));
	model.addAttribute("clientes", clienteDAO.listarTodos());
	return "pets/editar";
	}
	
	@PostMapping("/paginas/pets/editar")
	public String atualizar(@Valid @ModelAttribute Pet pet, BindingResult resultado) {
		
		if (resultado.hasErrors()) {
			return "clientes/editar";
			}
			dao.atualizar(pet);
			return "redirect:/paginas/pets";

	}
	
	@PostMapping("/paginas/pets/{id}/remover")
	public String remover(@PathVariable Long id) {
	dao.remover(id);
	return "redirect:/paginas/pets";
	}
	

}
