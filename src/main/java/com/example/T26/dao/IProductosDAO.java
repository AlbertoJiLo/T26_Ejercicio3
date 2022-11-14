package com.example.T26.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.T26.dto.Productos;


public interface IProductosDAO extends JpaRepository<Productos, Long>{
	
}
