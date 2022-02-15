package ec.edu.uce.service;

import ec.edu.uce.modelo.CitaMedica;

public interface ICitaMedicaService {

	void insertarCitaMedica(CitaMedica cita); // C

	CitaMedica buscarCitaMedica(Integer id); // R

	void actualizarCitaMedica(CitaMedica cita); // U

	void eliminarCitaMedica(Integer id); // D

}
