package com.example.T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.T26.dao.ICajerosDAO;
import com.example.T26.dto.Cajeros;

@Service
public class CajerosServiceImpl implements ICajerosService{
	
	//Utilizamos los metodos de la interface ICajeroDAO, es como si instanciaramos.
	@Autowired
	ICajerosDAO iCajeroDAO;
	
	@Override
	public List<Cajeros> listarCajeros() {
		return iCajeroDAO.findAll();
	}
	
	@Override
	public Cajeros crearCajero(Cajeros cajero) {
		return iCajeroDAO.save(cajero);
	}

	@Override
	public Cajeros leerCajero(Long codigo) {
		return iCajeroDAO.findById(codigo).get();
	}


	@Override
	public Cajeros actualizarCajero(Cajeros cajero) {
		return iCajeroDAO.save(cajero);
	}

	@Override
	public void borrarCajero(Long codigo) {
		iCajeroDAO.deleteById(codigo);
	}


}
