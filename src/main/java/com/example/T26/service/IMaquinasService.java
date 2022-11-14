package com.example.T26.service;

import java.util.List;

import com.example.T26.dto.Maquinas;

public interface IMaquinasService {

	//Metodos del CRUD
	
	public List<Maquinas> listarMaquinas(); //Listar All 
	
	public Maquinas crearMaquina(Maquinas maquinas);	//CREATE
	
	public Maquinas leerMaquina(Long codigo); // READ
		
	public Maquinas actualizarMaquina(Maquinas maquina); // UPDATE
	
	public void borrarMaquina(Long codigo);// DELETE
	
	
}