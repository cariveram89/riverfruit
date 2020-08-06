package com.crivera.riverfruit.model;

public class Alimento {
	private int id;
	private String nombre;
	public int getId() {
		return id;
	}
	
	
	public Alimento(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public Alimento(int id ) {
		this.id = id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


}
