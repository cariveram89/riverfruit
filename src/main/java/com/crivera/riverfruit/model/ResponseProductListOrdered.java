package com.crivera.riverfruit.model;

import java.util.List;

public class ResponseProductListOrdered {
	private String inicial;
	private List<Product> lista;
	
	
	public ResponseProductListOrdered(List<Product> lista) {
		
	}
	
	
	public ResponseProductListOrdered(String inicial, List<Product> lista) {
		
		this.inicial = inicial;
		this.lista = lista;
	}


	public String getInicial() {
		return inicial;
	}


	public void setInicial(String inicial) {
		this.inicial = inicial;
	}


	public List<Product> getLista() {
		return lista;
	}


	public void setLista(List<Product> lista) {
		this.lista = lista;
	}
	
	
	
	

}
