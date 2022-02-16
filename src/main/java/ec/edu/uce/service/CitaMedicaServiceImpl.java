package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.repository.ICitaMedicaRepo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService{
	
	@Autowired
	ICitaMedicaRepo citaRepo;

	@Override
	public void insertarCitaMedica(CitaMedica cita) {
		this.citaRepo.insertarCitaMedica(cita);
	}

	@Override
	public CitaMedica buscarCitaMedica(Integer id) {
		return this.citaRepo.buscarCitaMedica(id);
	}

	@Override
	public void actualizarCitaMedica(CitaMedica cita) {
		this.citaRepo.actualizarCitaMedica(cita);
	}

	@Override
	public void eliminarCitaMedica(Integer id) {
		this.citaRepo.eliminarCitaMedica(id);
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		return this.citaRepo.buscarPorNumero(numero);
	}

}
