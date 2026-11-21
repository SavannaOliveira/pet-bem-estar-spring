package br.edu.ifrs.petbemestar.dominio;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime dataHora;
    
    @ManyToOne
    private Cliente cliente;
    
    @Column(name = "servico")
    private List<Servico> servicos = new ArrayList<>();
    
    @ManyToOne
    private Pet pet;
    private SituacaoAgendamento situacao = SituacaoAgendamento.MARCADO;

    public Agendamento() {
    }

    public Agendamento(LocalDateTime dataHora, Servico servico) {
        setDataHora(dataHora);
        adicionarServico(servico);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        if (dataHora == null) {
            throw new IllegalArgumentException("Insira a data");
        }

        this.dataHora = dataHora;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void adicionarServico(Servico servico) {
        if (servico == null) {
            throw new IllegalArgumentException("Insira o servico");
        }

        servicos.add(servico);
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public SituacaoAgendamento getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoAgendamento situacao) {
        if (situacao == null) {
            throw new IllegalArgumentException("Insira a situacao");
        }

        this.situacao = situacao;
    }
    
	public void setCliente(Cliente cliente) {
	    this.cliente = cliente;
	}
};
