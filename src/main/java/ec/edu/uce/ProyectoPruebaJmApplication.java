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

		Paciente p1 = new Paciente();
		p1.setApellido("Almagro");
		p1.setCedula("17145987548");
		p1.setCodigoSeguro("5485");
		p1.setNombre("José");
		p1.setEstatura(155.30);
		p1.setGenero("Femenino");
		p1.setPeso(55.5);
		p1.setFechaNacimiento(LocalDateTime.of(1999, Month.DECEMBER, 8, 10, 30));

		Paciente p2 = new Paciente();
		p2.setApellido("Moncayo");
		p2.setCedula("17509985874");
		p2.setCodigoSeguro("6987HU");
		p2.setNombre("Jorge");
		p2.setEstatura(170.30);
		p2.setGenero("Masculino");
		p2.setPeso(80.5);
		p2.setFechaNacimiento(LocalDateTime.of(1977, Month.JANUARY, 15, 10, 30));

//		this.pacienteService.insertarPaciente(p2);
//		this.pacienteService.insertarPaciente(p1);

		Doctor d1 = new Doctor();
		d1.setNombre("Patricia");
		d1.setCedula("1784556666");
		d1.setApellido("Hernandez");
		d1.setFechaNacimiento(LocalDateTime.of(1975, Month.DECEMBER, 20, 10, 30));
		d1.setGenero("Femenino");
		d1.setNumeroConsultorio("5023D");

		Doctor d2 = new Doctor();
		d2.setNombre("Pedro");
		d2.setCedula("17509875689");
		d2.setApellido("Ramirez");
		d2.setFechaNacimiento(LocalDateTime.of(1980, Month.SEPTEMBER, 8, 10, 30));
		d2.setGenero("Masculino");
		d2.setNumeroConsultorio("5034C");
		

//		this.doctorService.insertarDoctor(d2);
//		this.doctorService.insertarDoctor(d1);
		

		
		this.gestorService.agendarCitaMedica("128C", LocalDateTime.of(2021, Month.JANUARY, 15, 10, 30), new BigDecimal(20.90) , "Santa Rita", "17509875689", "17145987548");
		this.gestorService.resultadoCita("12P", "Gripe", "Paracetamol", LocalDateTime.of(2023, Month.DECEMBER, 8, 10, 30));
		this.gestorService.reportePacientes(LocalDateTime.now(), "Masculino");
		
	}

}
