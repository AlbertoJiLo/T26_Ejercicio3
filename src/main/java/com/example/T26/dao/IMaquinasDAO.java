package com.example.T26.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.T26.dto.Maquinas;


public interface IMaquinasDAO extends JpaRepository<Maquinas, Long>{
	
}
