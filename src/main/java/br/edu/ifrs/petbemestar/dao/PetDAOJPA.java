package br.edu.ifrs.petbemestar.dao;
import java.util.List;
import org.springframework.stereotype.Repository;
import br.edu.ifrs.petbemestar.dominio.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PetDAOJPA implements PetDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void salvar(Pet pet) {
		em.persist(pet);
		}

	@Override
	public Pet buscarPorId(Long id) {
		return em.find(Pet.class, id);
		}

	@Override
	public List<Pet> listarTodos() {
		return em
		.createQuery("SELECT s FROM Pet s", Pet.class)
		.getResultList();
		}

	@Override
	public void atualizar(Pet pet) {
		em.merge(pet);
		}

	@Override
	public void remover(Long id) {
		Pet pet = em.find(Pet.class, id);
		if (pet != null) {
		em.remove(pet);
		}
		}
	
}