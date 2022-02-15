package ec.edu.uce.repository;

import ec.edu.uce.modelo.CitaMedica;

public interface ICitaMedicaRepo {
	
	void insertarCitaMedica(CitaMedica cita); //C
	
	CitaMedica buscarCitaMedica(Integer id); //R
	
	void actualizarCitaMedica(CitaMedica cita); //U
	
	void eliminarCitaMedica(Integer id); //D
	
	
	
	

}
