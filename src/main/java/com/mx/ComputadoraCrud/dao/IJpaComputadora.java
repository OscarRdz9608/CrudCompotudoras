package com.mx.ComputadoraCrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mx.ComputadoraCrud.domain.Computadora;


@Repository
public interface IJpaComputadora extends JpaRepository<Computadora, Integer>{
	
	@Query(nativeQuery = true, value="SELECT * FROM COMPUTADORAS_2024 WHERE PRECIO > :PRECIO")
	public List<Computadora> buscarPorPrecio(
			@Param("PRECIO") double precio);

}
