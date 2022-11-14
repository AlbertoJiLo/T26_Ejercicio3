package com.example.T26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.T26.dto.Ventas;
import com.example.T26.service.VentasServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorVentas {
	
	@Autowired
	VentasServiceImpl ventasServiceImpl;
	
	@GetMapping("/ventas")
	public List<Ventas> listarVentas(){
		return ventasServiceImpl.listarVentas();
	}
	
	@PostMapping("/ventas")
	public Ventas crearVenta(@RequestBody Ventas venta) {
		
		return ventasServiceImpl.crearVenta(venta);
		
	}
	
	
	@GetMapping("/ventas/{id}")
	public Ventas leerVenta(@PathVariable(name="id") Long id) {
		
		Ventas venta= new Ventas();
		
		venta=ventasServiceImpl.leerVenta(id);
		
		System.out.println("Venta segun ID: "+venta);
		
		return venta;
	}
	
	@PutMapping("/ventas/{id}")
	public Ventas actualizarVenta(@PathVariable(name="id")Long id,@RequestBody Ventas venta) {
		
		Ventas venta_seleccionado= new Ventas();
		Ventas venta_actualizado= new Ventas();
		
		venta_seleccionado= ventasServiceImpl.leerVenta(id);

		venta_seleccionado.setCajeros(venta.getCajeros());
		venta_seleccionado.setMaquinas(venta.getMaquinas());
		venta_seleccionado.setProductos(venta.getProductos());

		
		venta_actualizado = ventasServiceImpl.actualizarVenta(venta_seleccionado);
		
		System.out.println("El venta actualizado es: "+ venta_actualizado);
		
		return venta_actualizado;
	}
	
	@DeleteMapping("/ventas/{id}")
	public void borrarVenta(@PathVariable(name="id")Long id) {
		ventasServiceImpl.borrarVenta(id);
	}
	
	
}
