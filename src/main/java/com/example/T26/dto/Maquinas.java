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
@Table(name="maquinas_registradoras")

public class Maquinas {

	//Atributos de la entidad Empleado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private int piso;
	
	@OneToMany
	@JoinColumn(name="maquina")
	private List<Ventas> ventas;
	
	//Constructores
	
	public Maquinas() {
		
	}
	
	public Maquinas(Long codigo, int piso) {
		this.codigo=codigo;
		this.piso=piso;
	}

	//Getters setters
	
	public Long getCodigo() {
		return codigo;
	}
	
	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
		return "Maquinas [codigo = " + codigo +", piso = " + piso +" ] ";
	}
}
