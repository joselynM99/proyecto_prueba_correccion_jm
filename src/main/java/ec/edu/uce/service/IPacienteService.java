package ec.edu.uce.service;

import ec.edu.uce.modelo.Paciente;


public interface IPacienteService {
	
	void insertarPaciente(Paciente paciente); // C

	Paciente buscarPaciente(Integer id); // R

	void actualizarPaciente(Paciente paciente); // U

	void eliminarPaciente(Integer id); // D
	
	Paciente buscarPacienteCodigo(String codigo);
	


}
