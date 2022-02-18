package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.PacienteSencilla;
import ec.edu.uce.repository.IPacienteRepo;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepo pacienteRepo;

	@Override
	public void insertarPaciente(Paciente paciente) {
		this.pacienteRepo.insertarPaciente(paciente);
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		return this.pacienteRepo.buscarPaciente(id);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		this.pacienteRepo.actualizarPaciente(paciente);
	}

	@Override
	public void eliminarPaciente(Integer id) {
		this.pacienteRepo.eliminarPaciente(id);
	}

	@Override
	public Paciente buscarPacienteCedula(String cedula) {
		return this.pacienteRepo.buscarPacienteCedula(cedula);
	}

	@Override
	public List<PacienteSencilla> buscarPacientesPotFechaGenero(LocalDateTime fecha, String genero) {
		return this.pacienteRepo.buscarPacientesPotFechaGenero(fecha, genero);
	}

}
