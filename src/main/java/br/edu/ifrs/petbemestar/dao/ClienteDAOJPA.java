package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.edu.ifrs.petbemestar.dominio.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteDAOJPA implements ClienteDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Cliente cliente) {
		em.persist(cliente);
		}

	@Override
	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
		}

	@Override
	public List<Cliente> listarTodos() {
		return em
		.createQuery("SELECT s FROM Cliente s", Cliente.class)
		.getResultList();
		}

	@Override
	public void atualizar(Cliente cliente) {
		em.merge(cliente);
		}

	@Override
	public void remover(Long id) {
		Cliente cliente = em.find(Cliente.class, id);
		if (cliente != null) {
		em.remove(cliente);
		}
		}
	
}