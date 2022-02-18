package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.PacienteSencilla;

public interface ICitaMedicaRepo {

	void insertarCitaMedica(CitaMedica cita); // C

	CitaMedica buscarCitaMedica(Integer id); // R

	void actualizarCitaMedica(CitaMedica cita); // U

	void eliminarCitaMedica(Integer id); // D

	CitaMedica buscarPorNumero(String numero);

}
