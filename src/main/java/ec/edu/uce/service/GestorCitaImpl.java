package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.PacienteSencilla;

@Service
public class GestorCitaImpl implements IGestorCita {
	private static final Logger LOG = Logger.getRootLogger();

	@Autowired
	private IDoctorService doctorService;

	@Autowired
	private IPacienteService pacienteService;

	@Autowired
	ICitaMedicaService citaService;

	@Override
	public void agendarCitaMedica(String numeroCita, LocalDateTime fechaCita, BigDecimal valor, String lugar,
			String cedulaDoctor, String cedulaPaciente) {

		CitaMedica cita = new CitaMedica();
		cita.setNumero(numeroCita);
		cita.setFechaCita(fechaCita);
		cita.setValorCita(valor);
		cita.setLugar(lugar);

		Doctor d = this.doctorService.buscarDoctorPorCedula(cedulaDoctor);
		Paciente p = this.pacienteService.buscarPacienteCedula(cedulaPaciente);

		cita.setDoctor(d);
		cita.setPaciente(p);
		
		this.citaService.insertarCitaMedica(cita);
	}

	@Override
	public void resultadoCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima) {
		CitaMedica c1 = this.citaService.buscarPorNumero(numero);
		c1.setReceta(receta);
		c1.setFechaProximaCita(fechaProxima);
		c1.setDiagnostico(diagnostico);
		this.citaService.actualizarCitaMedica(c1);
	}

	@Override
	public void reportePacientes(LocalDateTime fecha, String genero) {

		List<PacienteSencilla> lista = this.pacienteService.buscarPacientesPotFechaGenero(fecha, genero);
		LOG.debug("Numero de pacientes: " +lista.size());
		for (PacienteSencilla p : lista) {
			LOG.info(p.toString());
		}

	}

}
