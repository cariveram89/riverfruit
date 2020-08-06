package com.crivera.riverfruit.model;

public class Status {
	private String descripcion;
	private int code;
	
	public Status (){
		
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Status [descripcion=" + descripcion + ", code=" + code + "]";
	}

}
