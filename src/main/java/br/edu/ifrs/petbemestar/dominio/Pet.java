package br.edu.ifrs.petbemestar.dominio;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Pet{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private TipoPet TipoPet;
	
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	
	@ManyToOne
	private Cliente cliente;
	
	public Pet(){
	}
	
	public Pet(String nome , Cliente cliente , TipoPet TipoPet ,Tamanho tamanho) {
		this.nome= nome;
		this.cliente = cliente;
		this.TipoPet = TipoPet;
		this.tamanho = tamanho;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Cliente getCliente() {
	    return cliente;
	}

	public void setCliente(Cliente cliente) {
	    this.cliente = cliente;
	}
	
	public Integer getId() {
	    return id;
	}

	public void setId(Integer id) {
	    this.id = id;
	}
	
	public TipoPet getTipoPet() {
	    return TipoPet;
	}

	public void setTipoPet(TipoPet TipoPet) {
	    this.TipoPet = TipoPet;
	}
	
	public Tamanho getTamanho() {
	    return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
	    this.tamanho = tamanho;
	}
	
}
