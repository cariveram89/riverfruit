package com.crivera.riverfruit.model;

public class CrearPersona {
	private Person persona;
	private String key;
	

	
	public CrearPersona() {
		
	}
	
	public CrearPersona(Person persona, String key) {
		
		this.persona = persona;
		this.key = key;
	}
	public Person getPersona() {
		return persona;
	}
	public void setPersona(Person persona) {
		this.persona = persona;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	
	

}
