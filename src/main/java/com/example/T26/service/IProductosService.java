package com.example.T26.service;

import java.util.List;

import com.example.T26.dto.Productos;

public interface IProductosService {

	//Metodos del CRUD
	
	public List<Productos> listarProductos(); //Listar All 
	
	public Productos crearProducto(Productos productos);	//CREATE
	
	public Productos leerProducto(Long codigo); // READ
		
	public Productos actualizarProducto(Productos producto); // UPDATE
	
	public void borrarProducto(Long codigo);// DELETE
	
	
}