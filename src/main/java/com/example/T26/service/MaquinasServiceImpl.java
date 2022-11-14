package com.example.T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.T26.dao.IMaquinasDAO;
import com.example.T26.dto.Maquinas;

@Service
public class MaquinasServiceImpl implements IMaquinasService{
	
	//Utilizamos los metodos de la interface IMaquinaDAO, es como si instanciaramos.
	@Autowired
	IMaquinasDAO iMaquinaDAO;
	
	@Override
	public List<Maquinas> listarMaquinas() {
		return iMaquinaDAO.findAll();
	}
	
	@Override
	public Maquinas leerMaquina(Long codigo) {
		return iMaquinaDAO.findById(codigo).get();
	}
	
	@Override
	public Maquinas crearMaquina(Maquinas maquina) {
		return iMaquinaDAO.save(maquina);
	}


	@Override
	public Maquinas actualizarMaquina(Maquinas maquina) {
		return iMaquinaDAO.save(maquina);
	}

	@Override
	public void borrarMaquina(Long codigo) {
		iMaquinaDAO.deleteById(codigo);
	}

		



}