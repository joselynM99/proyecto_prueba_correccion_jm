package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.PacienteSencilla;


public interface IPacienteService {
	
	void insertarPaciente(Paciente paciente); // C

	Paciente buscarPaciente(Integer id); // R

	void actualizarPaciente(Paciente paciente); // U

	void eliminarPaciente(Integer id); // D
	
	Paciente buscarPacienteCedula(String cedula);
	
	List<PacienteSencilla> buscarPacientesPotFechaGenero(LocalDateTime fecha, String genero);

}
