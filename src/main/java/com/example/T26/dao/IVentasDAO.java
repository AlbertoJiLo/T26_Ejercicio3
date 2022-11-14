package com.example.T26.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.T26.dto.Ventas;


public interface IVentasDAO extends JpaRepository<Ventas, Long>{
	
}
