package com.example.T26.service;

import java.util.List;

import com.example.T26.dto.Cajeros;

public interface ICajerosService {

	//Metodos del CRUD
	
	public List<Cajeros> listarCajeros(); //Listar All 
	
	public Cajeros crearCajero(Cajeros cajeros);	//CREATE
	
	public Cajeros leerCajero(Long codigo); // READ
		
	public Cajeros actualizarCajero(Cajeros cajero); // UPDATE
	
	public void borrarCajero(Long codigo);// DELETE
	
	
}