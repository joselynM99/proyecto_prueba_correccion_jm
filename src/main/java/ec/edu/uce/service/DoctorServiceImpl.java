package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.repository.IDoctorRepo;

@Service
public class DoctorServiceImpl implements IDoctorService{
	
	@Autowired
	private IDoctorRepo doctorRepo;

	@Override
	public void insertarDoctor(Doctor paciente) {
		this.doctorRepo.insertarDoctor(paciente);
	}

	@Override
	public Doctor buscarDoctor(Integer id) {
		return this.doctorRepo.buscarDoctor(id);
	}

	@Override
	public void actualizarDoctor(Doctor paciente) {
		this.doctorRepo.actualizarDoctor(paciente);
	}

	@Override
	public void eliminarDoctor(Integer id) {
		this.doctorRepo.eliminarDoctor(id);
	}

	@Override
	public Doctor buscarDoctorPorCedula(String cedula) {
		return this.doctorRepo.buscarDoctorPorCedula(cedula);
	}


}
