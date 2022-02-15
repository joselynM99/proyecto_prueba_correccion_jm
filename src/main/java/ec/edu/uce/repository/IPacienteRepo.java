package ec.edu.uce.repository;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteRepo {

	void insertarPaciente(Paciente paciente); // C

	Paciente buscarPaciente(Integer id); // R

	void actualizarPaciente(Paciente paciente); // U

	void eliminarPaciente(Integer id); // D
	
	Paciente buscarPacienteCodigo(String codigo);

}
