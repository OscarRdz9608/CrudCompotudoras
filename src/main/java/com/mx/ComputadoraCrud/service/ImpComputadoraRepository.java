package com.mx.ComputadoraCrud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.ComputadoraCrud.dao.ICrudComputadora;
import com.mx.ComputadoraCrud.dao.IJpaComputadora;
import com.mx.ComputadoraCrud.domain.Computadora;

@Service
public class ImpComputadoraRepository  implements IRepositoryComputadora{

	@Autowired
	private ICrudComputadora iCrudComputadora;
	@Autowired
	private IJpaComputadora iJpaComputadora;
	
	
	@Override
	public boolean guardar(Computadora computadora) {
	    // TODO Auto-generated method stub
	    List<Computadora> allComputers = (List<Computadora>) iCrudComputadora.findAll(); 
	    if(allComputers.isEmpty()) {
	        iCrudComputadora.save(computadora);
	        System.out.println("ComputadoraRegistrada: "+computadora.getModelo());
	        return true;
	    } else {
	       
	        for(Computadora comp: allComputers) {
	            if(comp.getModelo().equalsIgnoreCase(computadora.getModelo()) && comp.getMarca().equalsIgnoreCase(computadora.getMarca())) {
	                System.out.println("La computadora ya está registrada");
	                return false;
	            }
	        }
	       
	        iCrudComputadora.save(computadora);
	        return true;
	    }
	}

	@Override
	public List<Computadora> listar() {
		// TODO Auto-generated method stub
		List<Computadora> comp = (List<Computadora>) iCrudComputadora.findAll();
		if (comp.isEmpty()) {
			System.out.println("ListarVacio");
			return null;
		}else
		{
			return comp;
		}
		
	}

	@Override
	public boolean editar(Computadora computadora) {
		// TODO Auto-generated method stub
		if(iCrudComputadora.existsById(computadora.getId())) {
			iCrudComputadora.save(computadora);
			return true;
		}else {
		return false;
		}		
	}

	@Override
	public boolean eliminar(Computadora computadora) {
		// TODO Auto-generated method stub
		if(iCrudComputadora.existsById(computadora.getId())) {
			iCrudComputadora.delete(computadora);
			return true;
		}
		else {
			return false;
		}	
	}

	@Override
	public Computadora buscar(Computadora computadora) {
		// TODO Auto-generated method stub
		Computadora comp = iCrudComputadora.findById(computadora.getId()).orElse(null);	
		return comp;
	}

	@Override
	public List<Computadora> listarPrecio(Computadora computadora) {
		// TODO Auto-generated method stub
		List<Computadora> listPrecio = new ArrayList<>();
		if(computadora !=null) {
			listPrecio.addAll(  iJpaComputadora.buscarPorPrecio(computadora.getPrecio()));
		}
		return listPrecio;
		
	
	}

}
