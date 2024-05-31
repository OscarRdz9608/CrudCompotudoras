package com.mx.ComputadoraCrud.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.mx.ComputadoraCrud.domain.Computadora;

@Service
public interface IRepositoryComputadora {
	
	public boolean guardar(Computadora computadora);
	
	public List<Computadora> listar();
	
	public boolean editar(Computadora computadora);
	
	public boolean eliminar(Computadora computadora);
	
	public Computadora buscar(Computadora computadora);
	
	//POR JPARepository
	public List<Computadora> listarPrecio(Computadora computadora);
}
