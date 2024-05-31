package com.mx.ComputadoraCrud.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="COMPUTADORAS_2024")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Data
public class Computadora {
	
	@Id
	@Column(name="ID", columnDefinition = "NUMBER", length = 20, nullable = false)
	private int id;
	
	@Column(name="MARCA", columnDefinition = "NVARCHAR2(50)", length = 50, nullable = false)
	private String marca;
	
	@Column(name="MODELO", columnDefinition = "NVARCHAR2(50)", length = 50, nullable = false)
	private String modelo;
	
	@Column(name="COLOR", columnDefinition = "NVARCHAR2(50)", length = 50, nullable = false)
	private String color;
	
	@Column(name="PRECIO", columnDefinition = "NUMBER", length = 50, nullable = false)
	private double precio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
