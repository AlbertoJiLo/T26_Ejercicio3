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

import com.example.T26.dto.Cajeros;
import com.example.T26.service.CajerosServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorCajeros {
	
	@Autowired
	CajerosServiceImpl cajerosServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajeros> listarCajeros(){
		return cajerosServiceImpl.listarCajeros();
	}
	
	@PostMapping("/cajeros")
	public Cajeros crearCajero(@RequestBody Cajeros cajero) {
		
		return cajerosServiceImpl.crearCajero(cajero);
		
	}
	
	@GetMapping("/cajeros/{codigo}")
	public Cajeros leerCajero(@PathVariable(name="codigo") Long codigo) {
		
		Cajeros cajero= new Cajeros();
		
		cajero=cajerosServiceImpl.leerCajero(codigo);
		
		System.out.println("Cajero segun ID: "+cajero);
		
		return cajero;
	}
	
	@PutMapping("/cajeros/{codigo}")
	public Cajeros actualizarCajero(@PathVariable(name="codigo")Long codigo,@RequestBody Cajeros cajero) {
		
		Cajeros cajero_seleccionado= new Cajeros();
		Cajeros cajero_actualizado= new Cajeros();
		
		cajero_seleccionado= cajerosServiceImpl.leerCajero(codigo);

		cajero_seleccionado.setNomapels(cajero.getNomapels());
		
		cajero_actualizado = cajerosServiceImpl.actualizarCajero(cajero_seleccionado);
		
		System.out.println("La cajero actualizada es: "+ cajero_actualizado);
		
		return cajero_actualizado;
	}
	
	@DeleteMapping("/cajeros/{codigo}")
	public void borrarCajero(@PathVariable(name="codigo")Long codigo) {
		cajerosServiceImpl.borrarCajero(codigo);
	}
	
	
}
