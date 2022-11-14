package com.example.T26.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="venta")
public class Ventas{
	
	

	//Atributos de la entidad Empleado

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="producto")
	private Productos productos;
	
	@ManyToOne
	@JoinColumn(name="cajero")
	private Cajeros cajeros;
	
	@ManyToOne
	@JoinColumn(name="maquina")
	private Maquinas maquinas;
	
	
	//Constructores
	
	public Ventas() {
		
	}
	
	public Ventas(Long id,Productos productos, Cajeros cajeros,Maquinas maquinas) {
		this.id=id;
		this.productos=productos;
		this.cajeros=cajeros;
		this.maquinas=maquinas;
	}

	//Setters y getters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	public Cajeros getCajeros() {
		return cajeros;
	}

	public void setCajeros(Cajeros cajeros) {
		this.cajeros = cajeros;
	}

	public Maquinas getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(Maquinas maquinas) {
		this.maquinas = maquinas;
	}


	//To string personalizado
	@Override
	public String toString() {
		return "Asignado a [id = " +id+ ",productos = " + productos +", cajeros = " + cajeros +" ] ";
	}

	

}
