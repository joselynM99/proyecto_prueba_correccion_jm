package ec.edu.uce;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.service.IDoctorService;
import ec.edu.uce.service.IGestorCita;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class ProyectoPruebaJmApplication implements CommandLineRunner{
	private static final Logger LOG = Logger.getRootLogger();
	
	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IGestorCita gestorService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoPruebaJmApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		LocalDateTime fecha1 = LocalDateTime.of(1999, Month.DECEMBER, 8, 10, 30);
		LocalDateTime fecha2 = LocalDateTime.of(1977, Month.DECEMBER, 8, 10, 30);
		LocalDateTime fecha3 = LocalDateTime.of(2022, Month.DECEMBER, 8, 10, 30);

		Paciente p1 = new Paciente();
		p1.setApellido("Almagro");
		p1.setCedula("1750958874");
		p1.setCodigoSeguro("58949B");
		p1.setNombre("Joss");
		p1.setEstatura(155.30);
		p1.setGenero("Femenino");
		p1.setPeso(55.5);
		p1.setFechaNacimiento(fecha1);

		Paciente p2 = new Paciente();
		p2.setApellido("Moncayo");
		p2.setCedula("17509985874");
		p2.setCodigoSeguro("6987HU");
		p2.setNombre("Jorge");
		p2.setEstatura(170.30);
		p2.setGenero("Masculino");
		p2.setPeso(80.5);
		p2.setFechaNacimiento(fecha2);

		this.pacienteService.insertarPaciente(p2);
		this.pacienteService.insertarPaciente(p1);

		Doctor d1 = new Doctor();
		d1.setNombre("Patricia");
		d1.setCedula("1784556666");
		d1.setApellido("Hernandez");
		d1.setFechaNacimiento(fecha1);
		d1.setGenero("Femenino");
		d1.setNumeroConsultorio("50D");

		Doctor d2 = new Doctor();
		d2.setNombre("Juan");
		d2.setCedula("1784556666");
		d2.setApellido("Ramirez");
		d2.setFechaNacimiento(fecha2);
		d2.setGenero("Masculino");
		d2.setNumeroConsultorio("50C");
		
		this.doctorService.insertarDoctor(d2);
		this.doctorService.insertarDoctor(d1);
		
		Doctor d3 = new Doctor();
		d3.setNombre("Juan");
		d3.setCedula("1784556666");
		d3.setApellido("Perez");
		d3.setFechaNacimiento(fecha2);
		d3.setGenero("Masculino");
		d3.setNumeroConsultorio("89L");
		d3.setId(1);
		
		this.doctorService.actualizarDoctor(d3);
		
		Paciente p3 = new Paciente();
		p3.setApellido("Moncayo");
		p3.setCedula("17509985874");
		p3.setCodigoSeguro("58949CF");
		p3.setNombre("Jorge");
		p3.setEstatura(170.30);
		p3.setGenero("Masculino");
		p3.setPeso(90.5);
		p3.setFechaNacimiento(fecha2);
		p3.setId(4);
		
		this.pacienteService.actualizarPaciente(p3);
		
		this.gestorService.agendarCitaMedica("1258P", fecha3, new BigDecimal(20.90) , "Santa Rita", "Perez", "69452HU");
		
		
	}

}
