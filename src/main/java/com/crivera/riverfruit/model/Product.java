package com.crivera.riverfruit.model;

public class Product implements Comparable<Product> {
	
	private String name;
    private String code;
    
    public Product () {
    	
    }
    
	public Product(String name, String code) {
		
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", code=" + code + "]";
	}

	@Override
	public int compareTo(Product p) {
		// TODO Auto-generated method stub
		//aqui se pone el cristerio de comparacion 
		//this .code -p.code
		// se esta comparando la primera letra de cada palbra 
		return this.code.charAt(0) - p.code.charAt(0);
	}


}
