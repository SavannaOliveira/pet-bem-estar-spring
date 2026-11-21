package br.edu.ifrs.petbemestar.dominio;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String telefone;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pet> pets = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente")
	private List<Agendamento> agendamentos  = new ArrayList<>();
	
	public Cliente() {
	}
	
	public Cliente(String nome, String telefone) {
		this.nome = nome; 
		this.telefone = telefone;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getTel() {
		return telefone;
	}
	
	public void setTel(String telefone) {
		this.telefone = telefone;
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
