package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {
	private static final Logger LOG = Logger.getRootLogger();

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarPaciente(Paciente paciente) {
		this.entityManager.persist(paciente);
		LOG.info("Paciente insertado: "+ paciente);

	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		this.entityManager.merge(paciente);
		LOG.info("Paciente actualizado: "+ paciente);

	}

	@Override
	public void eliminarPaciente(Integer id) {
		Paciente paciente = this.buscarPaciente(id);
		this.entityManager.remove(paciente);
	}

	@Override
	public Paciente buscarPacienteCodigo(String codigo) {
		TypedQuery<Paciente> myQuery = this.entityManager
				.createQuery("SELECT p FROM Paciente p WHERE p.codigoSeguro =: codigo", Paciente.class);
		myQuery.setParameter("codigo", codigo);
		
		return myQuery.getSingleResult();
	}

}
