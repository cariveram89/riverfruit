package com.crivera.riverfruit.entidad;

public class Resolution {
	//se van a obtener los 3 
	private String code;
	private String name ;
	private Long price;
	
	public Resolution() {
		
	}

	public Resolution(String codigo, String name, Long price) {
		
		this.code = codigo;
		this.name = name;
		this.price = price;
	}

	public String getCodigo() {
		return code;
	}

	public void setCodigo(String codigo) {
		this.code = codigo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Resolution [codigo=" + code + ", name=" + name + ", price=" + price + "]";
	}
	
	
	
	
	
	
	
	

}
