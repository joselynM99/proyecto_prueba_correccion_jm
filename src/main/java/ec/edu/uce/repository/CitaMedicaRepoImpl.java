package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Paciente;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {
	private static final Logger LOG = Logger.getRootLogger();

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarCitaMedica(CitaMedica cita) {
		this.entityManager.persist(cita);
		LOG.info("Cita insertada: " + cita);

	}

	@Override
	public CitaMedica buscarCitaMedica(Integer id) {
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void actualizarCitaMedica(CitaMedica cita) {
		this.entityManager.merge(cita);
		LOG.info("Cita actualizada: " + cita);

	}

	@Override
	public void eliminarCitaMedica(Integer id) {
		CitaMedica cita = this.buscarCitaMedica(id);
		this.entityManager.remove(cita);
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		TypedQuery<CitaMedica> myQuery = this.entityManager
				.createQuery("SELECT c FROM CitaMedica c WHERE c.numero =: numero", CitaMedica.class);
		myQuery.setParameter("numero", numero);

		return myQuery.getSingleResult();
	}

}
