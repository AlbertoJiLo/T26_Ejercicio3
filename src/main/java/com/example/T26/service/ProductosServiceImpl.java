package com.example.T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.T26.dao.IProductosDAO;
import com.example.T26.dto.Productos;

@Service
public class ProductosServiceImpl implements IProductosService{
	
	//Utilizamos los metodos de la interface IProductoDAO, es como si instanciaramos.
	@Autowired
	IProductosDAO iProductoDAO;
	
	@Override
	public List<Productos> listarProductos() {
		return iProductoDAO.findAll();
	}
	
	@Override
	public Productos crearProducto(Productos codigo) {
		return iProductoDAO.save(codigo);
	}

	@Override
	public Productos leerProducto(Long codigo) {
		return iProductoDAO.findById(codigo).get();
	}


	@Override
	public Productos actualizarProducto(Productos producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public void borrarProducto(Long codigo) {
		iProductoDAO.deleteById(codigo);
	}

}