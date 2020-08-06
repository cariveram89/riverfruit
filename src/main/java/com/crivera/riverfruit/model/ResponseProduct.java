package com.crivera.riverfruit.model;



public class ResponseProduct {
	private Status status;
	private Product product;
	
	public ResponseProduct() {
		
	}
	
	public ResponseProduct(Status status) {
		
		this.status = status;
	}
	public ResponseProduct(Product product, Status status) {
		this.product= product;
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ResponseProduct [status=" + status + ", product=" + product + "]";
	}

}
