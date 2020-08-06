package com.crivera.riverfruit.model;

import java.util.List;

public class ResponseProductList {
	private Status status;
	private List<Product> lista;
	
	
	
	public ResponseProductList() {
		
	}
	
	
	public ResponseProductList(Status status, List<Product> lista) {
		super();
		this.status = status;
		this.lista = lista;
	}


	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Product> getLista() {
		return lista;
	}
	public void setLista(List<Product> lista) {
		this.lista = lista;
	}
	@Override
	public String toString() {
		return "ResponseProductList [status=" + status + ", lista=" + lista + "]";
	}

	
}
