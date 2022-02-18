package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.PacienteSencilla;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {
	private static final Logger LOG = Logger.getRootLogger();

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarPaciente(Paciente paciente) {
		this.entityManager.persist(paciente);
		LOG.debug("Paciente insertado: "+ paciente);

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
	public Paciente buscarPacienteCedula(String cedula) {
		TypedQuery<Paciente> myQuery = this.entityManager
				.createQuery("SELECT p FROM Paciente p WHERE p.cedula =: cedula", Paciente.class);
		myQuery.setParameter("cedula", cedula);
		
		return myQuery.getSingleResult();
	}
	
	@Override
	public List<PacienteSencilla> buscarPacientesPotFechaGenero(LocalDateTime fecha, String genero) {

		TypedQuery<PacienteSencilla> myQuery = this.entityManager.createQuery(
				"SELECT NEW ec.edu.uce.modelo.PacienteSencilla(p.cedula, p.nombre, p.fechaNacimiento, p.genero) FROM Paciente p WHERE p.fechaNacimiento <=: fecha AND p.genero =: genero",
				PacienteSencilla.class);

		myQuery.setParameter("fecha", fecha);
		myQuery.setParameter("genero", genero);

		return myQuery.getResultList();

	}

}
