package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;

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
			String apellidoDoctor, String codigoPaciente) {

		CitaMedica cita = new CitaMedica();
		cita.setNumero(numeroCita);
		cita.setFechaCita(fechaCita);
		cita.setValorCita(valor);
		cita.setLugar(lugar);

		Doctor d = this.doctorService.buscarDoctorPorApellido(apellidoDoctor);
		Paciente p = this.pacienteService.buscarPacienteCodigo(codigoPaciente);

		cita.setDoctor(d);
		cita.setPaciente(p);

		LocalDateTime fechaActual = LocalDateTime.now();

		if (fechaActual.compareTo(fechaCita) < 0) {
			BigDecimal iva= valor.multiply(new BigDecimal(0.12));
			BigDecimal valorImpuestos = valor.add(iva);
			cita.setValorCita(valorImpuestos);
			this.citaService.insertarCitaMedica(cita);

		} else {
			LOG.warn("No se ha podido generar cita");
		}
		
		

	}

	@Override
	public void resultadoCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima) {
		CitaMedica c1=this.citaService.buscarPorNumero(numero);
		c1.setReceta(receta);
		c1.setFechaProximaCita(fechaProxima);
		this.citaService.actualizarCitaMedica(c1);
	}

}
