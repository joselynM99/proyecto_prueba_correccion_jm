package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface IGestorCita {

	void agendarCitaMedica(String numeroCita, LocalDateTime fachaCita, BigDecimal valor, String lugar,
			String apellidoDoctor, String codigoPaciente);

	void resultadoCita(String numero, String diagnostico, String receta, LocalDateTime fechaProxima);
}

