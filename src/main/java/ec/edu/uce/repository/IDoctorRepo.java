package ec.edu.uce.repository;

import ec.edu.uce.modelo.Doctor;

public interface IDoctorRepo {

	void insertarDoctor(Doctor doctor); // C

	Doctor buscarDoctor(Integer id); // R

	void actualizarDoctor(Doctor doctor); // U

	void eliminarDoctor(Integer id); // D
	
	Doctor buscarDoctorPorApellido(String apellido);

}
