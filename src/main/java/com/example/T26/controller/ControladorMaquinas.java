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

import com.example.T26.dto.Maquinas;
import com.example.T26.service.MaquinasServiceImpl;

@RestController
@RequestMapping("/api")
public class ControladorMaquinas {
	
	@Autowired
	MaquinasServiceImpl maquinasServiceImpl;
	
	@GetMapping("/maquinas")
	public List<Maquinas> listarMaquinas(){
		return maquinasServiceImpl.listarMaquinas();
	}
	
	@PostMapping("/maquinas")
	public Maquinas crearMaquina(@RequestBody Maquinas maquina) {
		
		return maquinasServiceImpl.crearMaquina(maquina);
		
	}
	
	
	@GetMapping("/maquinas/{codigo}")
	public Maquinas leerMaquina(@PathVariable(name="codigo") Long codigo) {
		
		Maquinas maquina= new Maquinas();
		
		maquina=maquinasServiceImpl.leerMaquina(codigo);
		
		System.out.println("Maquina segun ID: "+maquina);
		
		return maquina;
	}
	
	@PutMapping("/maquinas/{codigo}")
	public Maquinas actualizarMaquina(@PathVariable(name="codigo")Long codigo,@RequestBody Maquinas maquina) {
		
		Maquinas maquina_seleccionado= new Maquinas();
		Maquinas maquina_actualizado= new Maquinas();
		
		maquina_seleccionado= maquinasServiceImpl.leerMaquina(codigo);

		maquina_seleccionado.setPiso(maquina.getPiso());

		
		maquina_actualizado = maquinasServiceImpl.actualizarMaquina(maquina_seleccionado);
		
		System.out.println("La maquina actualizada es: "+ maquina_actualizado);
		
		return maquina_actualizado;
	}
	
	@DeleteMapping("/maquinas/{codigo}")
	public void borrarMaquina(@PathVariable(name="codigo") Long codigo) {
		maquinasServiceImpl.borrarMaquina(codigo);
	}
	
	
}
