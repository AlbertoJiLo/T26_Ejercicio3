package com.example.T26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.T26.dao.IVentasDAO;
import com.example.T26.dto.Ventas;

@Service
public class VentasServiceImpl implements VentasService{
	
	//Utilizamos los metodos de la interface IVentaDAO, es como si instanciaramos.
	@Autowired
	IVentasDAO iVentaDAO;
	
	@Override
	public List<Ventas> listarVentas() {
		return iVentaDAO.findAll();
	}
	
	@Override
	public Ventas leerVenta(Long id) {
		return iVentaDAO.findById(id).get();
	}
	
	@Override
	public Ventas crearVenta(Ventas venta) {
		return iVentaDAO.save(venta);
	}


	@Override
	public Ventas actualizarVenta(Ventas venta) {
		return iVentaDAO.save(venta);
	}

	@Override
	public void borrarVenta(Long id) {
		iVentaDAO.deleteById(id);
	}

		



}
