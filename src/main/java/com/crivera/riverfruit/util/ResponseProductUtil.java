package com.crivera.riverfruit.util;

import java.util.List;

import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.ResponseProduct;
import com.crivera.riverfruit.model.ResponseProductList;
import com.crivera.riverfruit.model.ResponseProductListOrdered;
import com.crivera.riverfruit.model.Status;

public class ResponseProductUtil {
	public ResponseProductList buildListProduct(Integer statusCode, String statusDescricion, Product product ) {
		//le tengo que mandar la lista d eproductos 
		
		Status status = new Status();
		 status.setCode(statusCode);
		 status.setDescripcion(statusDescricion);
		
	return new ResponseProductList();
	}
	public ResponseProductListOrdered organizarLista(List<Product> listProduct ) {
		
		
		return new ResponseProductListOrdered(listProduct);
	}
	
	public ResponseProduct buildProduct(Integer statusCode, String statusDescricion, Product product ) {
		//le tengo que mandar la lista d eproductos 
		
		Status status = new Status();
		 status.setCode(statusCode);
		 status.setDescripcion(statusDescricion);
		
	return new ResponseProduct(product, status);
	
	}
	
	

}
