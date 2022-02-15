package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cita_medica")
public class CitaMedica {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cime")
	@SequenceGenerator(name = "seq_cime", sequenceName = "seq_cime", allocationSize = 1)
	@Column(name = "cime_id")
	private Integer id;

	@Column(name = "cime_numero")
	private String numero;

	@Column(name = "cime_fecha_cita")
	private LocalDateTime fechaCita;

	@Column(name = "cime_valor_cita")
	private BigDecimal valorCita;

	@Column(name = "cime_lugar")
	private String lugar;

	@Column(name = "cime_receta")
	private String receta;

	@Column(name = "cime_fecha_proxima_cita")
	private LocalDateTime fechaProximaCita;

	@ManyToOne
	@JoinColumn(name = "paci_id")
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "doct_id")
	private Doctor doctor;

	// Metodos set y get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public BigDecimal getValorCita() {
		return valorCita;
	}

	public void setValorCita(BigDecimal valorCita) {
		this.valorCita = valorCita;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getReceta() {
		return receta;
	}

	public void setReceta(String receta) {
		this.receta = receta;
	}

	public LocalDateTime getFechaProximaCita() {
		return fechaProximaCita;
	}

	public void setFechaProximaCita(LocalDateTime fechaProximaCita) {
		this.fechaProximaCita = fechaProximaCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "CitaMedica [id=" + id + ", numero=" + numero + ", fechaCita=" + fechaCita + ", valorCita=" + valorCita
				+ ", lugar=" + lugar + ", receta=" + receta + ", fechaProximaCita=" + fechaProximaCita + "]";
	}
	
	

}
