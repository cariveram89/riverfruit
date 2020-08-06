package com.crivera.riverfruit.model;

import java.util.List;

public class GroupProduct {
	String code;
	List<Product> products;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	

}
