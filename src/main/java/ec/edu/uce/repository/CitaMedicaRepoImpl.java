package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo{
	private static final Logger LOG = Logger.getRootLogger();
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarCitaMedica(CitaMedica cita) {
		this.entityManager.persist(cita);
		LOG.info("Cita insertada: "+ cita);

	}

	@Override
	public CitaMedica buscarCitaMedica(Integer id) {
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void actualizarCitaMedica(CitaMedica cita) {
		this.entityManager.merge(cita);
		LOG.info("Cita actualizada: "+ cita);

	}

	@Override
	public void eliminarCitaMedica(Integer id) {
		CitaMedica cita =this.buscarCitaMedica(id);
		this.entityManager.remove(cita);
	}

}
