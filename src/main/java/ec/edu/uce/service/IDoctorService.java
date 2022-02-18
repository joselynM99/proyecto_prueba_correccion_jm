package ec.edu.uce.service;

import ec.edu.uce.modelo.Doctor;

public interface IDoctorService {
	
	void insertarDoctor(Doctor doctor); // C

	Doctor buscarDoctor(Integer id); // R

	void actualizarDoctor(Doctor paciente); // U

	void eliminarDoctor(Integer id); // D
	
	Doctor buscarDoctorPorCedula(String cedula);

}
