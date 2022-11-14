package com.example.T26.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="productos")

public class Productos {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nombre;
	private int precio;
	
	@OneToMany
	@JoinColumn(name="producto")
	private List<Ventas> ventas;
	
	//Constructores
	
	public Productos() {
		
	}
	
	public Productos(Long codigo, String nombre, int precio) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.precio=precio;
	}

	//Setters y getters
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado_A")
	public List<Ventas> getVentas() {
		return ventas;
	}


	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
	}

	//To string personalizado
	@Override
	public String toString() {
		return "Proyectos [codigo = " + codigo +", nombre = " + nombre +", precio = " + precio +" ] ";
	}
}