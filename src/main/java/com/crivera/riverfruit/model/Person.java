package com.crivera.riverfruit.model;

import java.util.Date;

public class Person {
  
	private String identificacion;
	private String nombre;
private	 Date fechaNacimiento;

public Person() {
	
}

public Person(String identificacion, String nombre, Date fechaNacimiento) {


	this.identificacion = identificacion;
	this.nombre = nombre;
	this.fechaNacimiento = fechaNacimiento;
}


public String getIdentificacion() {
	return identificacion;
}

public void setIdentificacion(String identificacion) {
	this.identificacion = identificacion;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public Date getFechaNacimiento() {
	return fechaNacimiento;
}

public void setFechaNacimiento(Date fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}







}
