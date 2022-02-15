package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo {
	private static final Logger LOG = Logger.getRootLogger();

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarDoctor(Doctor doctor) {
		this.entityManager.persist(doctor);
		LOG.info("Doctor insertado: "+ doctor);
	}

	@Override
	public Doctor buscarDoctor(Integer id) {
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void actualizarDoctor(Doctor doctor) {
		this.entityManager.merge(doctor);
		LOG.info("Doctor actualizado: "+ doctor);
	}

	@Override
	public void eliminarDoctor(Integer id) {
		Doctor doctor = this.buscarDoctor(id);
		this.entityManager.remove(doctor);
	}

	@Override
	public Doctor buscarDoctorPorApellido(String apellido) {
		TypedQuery<Doctor> myQuery = this.entityManager
				.createQuery("SELECT d FROM Doctor d WHERE d.apellido =: apellido", Doctor.class);
		myQuery.setParameter("apellido", apellido);
		List<Doctor> lista = myQuery.getResultList();
		
		return lista.get(0);

	}

}
