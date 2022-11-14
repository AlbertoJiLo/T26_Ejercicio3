package com.example.T26.service;

import java.util.List;

import com.example.T26.dto.Ventas;

public interface VentasService {

	//Metodos del CRUD
	
	public List<Ventas> listarVentas(); //Listar All 
	
	public Ventas crearVenta(Ventas ventas);	//CREATE
			
	public Ventas actualizarVenta(Ventas venta); // UPDATE
	
	public void borrarVenta(Long id);// DELETE

	public Ventas leerVenta(Long id); // READ
		
}
