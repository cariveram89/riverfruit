package com.crivera.riverfruit.model;

public class VentaProductos {
	private String name;//codigo
	private String valor;//valor del producto

    public VentaProductos(String name, String valor) {
	
		this.name = name;
		this.valor = valor;
	}
    public VentaProductos() {
  		
  	}
	public String getcodigo() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String string) {
		this.valor = string;
	}
    

    

    
    

}
