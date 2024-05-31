package com.mx.ComputadoraCrud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import com.mx.ComputadoraCrud.domain.Computadora;
import com.mx.ComputadoraCrud.service.ImpComputadoraRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class WebService {

    @Autowired
    ImpComputadoraRepository impComputadoraRepository;

    @GetMapping("")
    public ResponseEntity<String> test() {
        System.out.println("Endpoint de prueba alcanzado");
        return ResponseEntity.ok("OK");
    }
    
    
    @GetMapping("/all")
    public ResponseEntity<?> listar() {
        System.out.println("Listando todas las computadoras");
        List<Computadora> computerList = impComputadoraRepository.listar();
        if (computerList.isEmpty()) {
            String respuesta = "No existen computadoras";
            return new ResponseEntity<>(respuesta, HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok(computerList);
        }
    }
    

    @PostMapping("/edit")
    public ResponseEntity<Map<String, String>> editar(@RequestBody Computadora computadora){
        Map<String, String> respuesta = new HashMap<>();
        HttpStatus status;
        if (impComputadoraRepository.editar(computadora)) {
            respuesta.put("Mensaje", "Se edito la computadora");
            status = HttpStatus.OK;
        } else {
            respuesta.put("Mensaje", "No se editola computadora");
            status = HttpStatus.CONFLICT;
        }
        
        return new ResponseEntity<>(respuesta, status);   	
    }
    
    @PostMapping("/delete")
    public ResponseEntity<Map<String, String>>eliminar(@RequestBody Computadora computadora){
    	 Map<String, String> respuesta = new HashMap<>();
         HttpStatus status;
         if (impComputadoraRepository.eliminar(computadora)) {
             respuesta.put("Mensaje", "Se elimino la computadora");
             status = HttpStatus.OK;
         } else {
             respuesta.put("Mensaje", "No se elimino la computadora");
             status = HttpStatus.CONFLICT;
         }
         
         return new ResponseEntity<>(respuesta, status);   
    	}   
    
    

    
    
    
    
    @PostMapping("/save")
    public ResponseEntity<Map<String, String>> guardar (@RequestBody Computadora computadora) {
        Map<String, String> respuesta = new HashMap<>();
        HttpStatus status;

        if (impComputadoraRepository.guardar(computadora)) {
            respuesta.put("Mensaje", "Se guardo la computadora");
            status = HttpStatus.OK;
        } else {
            respuesta.put("Mensaje", "No se guardo la computadora");
            status = HttpStatus.CONFLICT;
        }
        
        return new ResponseEntity<>(respuesta, status);
    }
    
    
    
    
    @PostMapping("/search")
    public ResponseEntity<?> buscar(@RequestBody Computadora computadora){
    	Computadora comp = impComputadoraRepository.buscar(computadora);
    	if(comp != null) {
    	    return ResponseEntity.ok(comp);
    	}else {
    		String respuesta = null;
    		respuesta = "No se encontro la computadora";
            return new ResponseEntity<>(respuesta, HttpStatus.NO_CONTENT);

    	}
    }
    
  
    @PostMapping("/price")
    public ResponseEntity<?> buscarPerecio(@RequestBody Computadora computadora){
    	List<Computadora> list = impComputadoraRepository.listarPrecio(computadora);
    	if(list.isEmpty()) {
    		String respuesta = null;
    		respuesta = "No se encontro la computadora";
            return new ResponseEntity<>(respuesta, HttpStatus.NO_CONTENT);    		
    	}else {
    		return ResponseEntity.ok(list);

    	}
    }
    
    
    
    
    
}
