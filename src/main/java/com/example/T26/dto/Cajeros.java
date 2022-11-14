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
@Table(name="cajeros")

public class Cajeros {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nomapels;
	
	@OneToMany
	@JoinColumn(name="cajero")
	private List<Ventas> ventas;
	
	//Constructores
	
	public Cajeros() {
		
	}
	
	public Cajeros(Long codigo, String nomapels) {
		this.codigo=codigo;
		this.nomapels=nomapels;
	}

	//Getters setters
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomapels() {
		return nomapels;
	}

	public void setNomapels(String nomapels) {
		this.nomapels = nomapels;
	}

	public void setVentas(List<Ventas> ventas) {
		this.ventas = ventas;
	}
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Ventas")
	public List<Ventas> getVentas() {
		return ventas;
	}




	//To string personalizado
	@Override
	public String toString() {
		return "Cajeros [codigo = " + codigo +", nombre y apellidos = " + nomapels +" ] ";
	}
}
