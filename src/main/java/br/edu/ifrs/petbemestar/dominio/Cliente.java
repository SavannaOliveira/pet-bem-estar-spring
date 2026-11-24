package br.edu.ifrs.petbemestar.dominio;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @NotBlank(message = "Informe o nome.")
	private String nome;
	
    @NotBlank(message = "Informe o telefone.")	
	private String tel;
	
		
	@OneToMany(mappedBy = "cliente")
	private List<Pet> pets = new ArrayList<>();
		
	
	@OneToMany(mappedBy = "cliente")
	private List<Agendamento> agendamentos  = new ArrayList<>();
	
	public Cliente() {
	}
	
	public Cliente(String nome, String tel) {
		this.nome = nome; 
		this.tel = tel;
	}
	
    public Long getId() {
		return id;
	}
	   
	public void setId(Long id) {
		this.id = id;
	}
	   
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public void adicionarPet(Pet pet) {
	    pets.add(pet);
	    pet.setCliente(this);
	}
	
	public void adicionarAgendamento(Agendamento agendamento) {
	    agendamentos.add(agendamento);
	    agendamento.setCliente(this);
	}

	
	
}
