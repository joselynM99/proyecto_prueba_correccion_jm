package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Doctor;

public interface IDoctorService {
	
	void insertarDoctor(Doctor doctor); // C

	Doctor buscarDoctor(Integer id); // R

	void actualizarDoctor(Doctor paciente); // U

	void eliminarDoctor(Integer id); // D
	
	Doctor buscarDoctorPorApellido(String apellido);

}
