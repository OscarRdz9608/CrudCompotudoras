package com.mx.ComputadoraCrud.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mx.ComputadoraCrud.domain.Computadora;

@Repository
public interface ICrudComputadora extends CrudRepository<Computadora, Integer>{

}
