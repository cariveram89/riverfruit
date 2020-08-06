package com.crivera.riverfruit.model;

public class ProductSaleOrder {
	//F1;FRESA;4;130000
private	String code ;//F1
private	String product;//FRESA
private	long salesQuantity;//4
private	long total;//130000

public ProductSaleOrder() {
	
}

public ProductSaleOrder(String code, String product, long salesQuantity, long total) {
	
	this.code = code;
	this.product = product;
	this.salesQuantity = salesQuantity;
	this.total = total;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getProduct() {
	return product;
}

public void setProduct(String product) {
	this.product = product;
}

public long getSalesQuantity() {
	return salesQuantity;
}

public void setSalesQuantity(long salesQuantity) {
	this.salesQuantity = salesQuantity;
}

public long getTotal() {
	return total;
}

public void setTotal(long total) {
	this.total = total;
}






}
