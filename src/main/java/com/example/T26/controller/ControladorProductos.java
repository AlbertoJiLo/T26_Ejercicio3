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

import com.example.T26.dto.Productos;
import com.example.T26.service.ProductosServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorProductos {
	
	@Autowired
	ProductosServiceImpl productosServiceImpl;
	
	@GetMapping("/productos")
	public List<Productos> listarProductos(){
		return productosServiceImpl.listarProductos();
	}
	
	@PostMapping("/productos")
	public Productos crearProducto(@RequestBody Productos producto) {
		
		return productosServiceImpl.crearProducto(producto);
		
	}
	
	
	@GetMapping("/productos/{codigo}")
	public Productos leerProducto(@PathVariable(name="codigo") Long codigo) {
		
		Productos producto= new Productos();
		
		producto=productosServiceImpl.leerProducto(codigo);
		
		System.out.println("Producto segun ID: "+producto);
		
		return producto;
	}
	
	@PutMapping("/productos/{codigo}")
	public Productos actualizarProducto(@PathVariable(name="codigo")Long codigo,@RequestBody Productos producto) {
		
		Productos producto_seleccionado= new Productos();
		Productos producto_actualizado= new Productos();
		
		producto_seleccionado= productosServiceImpl.leerProducto(codigo);

		producto_seleccionado.setNombre(producto.getNombre());
		producto_seleccionado.setPrecio(producto.getPrecio());
		
		producto_actualizado = productosServiceImpl.actualizarProducto(producto_seleccionado);
		
		System.out.println("La producto actualizada es: "+ producto_actualizado);
		
		return producto_actualizado;
	}
	
	@DeleteMapping("/productos/{codigo}")
	public void borrarProducto(@PathVariable(name="codigo") Long codigo) {
		productosServiceImpl.borrarProducto(codigo);
	}
	
	
}
