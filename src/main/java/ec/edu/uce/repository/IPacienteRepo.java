package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.PacienteSencilla;

public interface IPacienteRepo {

	void insertarPaciente(Paciente paciente); // C

	Paciente buscarPaciente(Integer id); // R

	void actualizarPaciente(Paciente paciente); // U

	void eliminarPaciente(Integer id); // D

	Paciente buscarPacienteCedula(String cedula);

	List<PacienteSencilla> buscarPacientesPotFechaGenero(LocalDateTime fecha, String genero);

}
