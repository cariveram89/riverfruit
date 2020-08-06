package com.crivera.riverfruit.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import com.crivera.riverfruit.dao.ProductDao;
import com.crivera.riverfruit.entidad.ProductEntity;
import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.Status;
import com.crivera.riverfruit.util.DbUtil;
import com.crivera.riverfruit.util.FileUtil;

public class ProductServiceBD {
	
	public Status postProductBD( ProductEntity productEntity) {
		DbUtil conexion = new DbUtil();
		conexion.connectionDb();
       
        Status status = new Status();
	try {
		DbUtil bd = new DbUtil();
		Connection connection = bd.connectionDb();
		ProductDao dao = new ProductDao();
		//mirar si el rpoducto ya existe 
	boolean exist =	dao.isProductExist(productEntity.getCode());
	if (exist == false ) {
		dao.postProducts1(connection, productEntity);
	    System.out.println("Inserto");
	    //status 
	   // Status status = new Status();
	    //Status status = new Status();
		status.setCode(200);
		status.setDescripcion("Producto creado");
		return  status;
	    
	}else {
		//status 
		System.out.println("el producto ya existe " );
		//Status status = new Status();
		status.setCode(400);
		status.setDescripcion("el productoya existe ");
		return  status;
	    
	}
	  	
		}   
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error en conection data base" + " - " + e);
		e.printStackTrace();
		status.setCode(500);
		status.setDescripcion("Error en la creacion del producto ");
		return  status;
	}
	
		 
		}
	public Status putProductBD( String code,ProductEntity productEntity) {
		DbUtil conexion = new DbUtil();
		conexion.connectionDb();
        Status status = new Status();
	try {
		DbUtil bd = new DbUtil();
		Connection connection = bd.connectionDb();
		ProductDao dao = new ProductDao();
		//mirar si el rpoducto ya existe 
	boolean exist =	dao.isProductExist(productEntity.getCode());
	if (exist == false ) {
		
		dao.putProducts1(connection, productEntity, code);
		status.setCode(200);
		status.setDescripcion("Producto no existe ");
		return  status;
	    
	}else {
		dao.putProducts1(connection, productEntity,code);
		status.setCode(400);
		status.setDescripcion("el producto fue modificado   ");
		return  status;
	}
		}   
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error en conection data base" + " - " + e);
		e.printStackTrace();
		status.setCode(500);
		status.setDescripcion("Error en la creacion del producto ");
		return  status;
	}
	
		 
		}
	
	
	public Status deleteProductBD( String code) {
		DbUtil conexion = new DbUtil();
		conexion.connectionDb();
       
        Status status = new Status();
	try {
		DbUtil bd = new DbUtil();
		Connection connection = bd.connectionDb();
		ProductDao dao = new ProductDao();
		//mirar si el rpoducto ya existe 
	boolean exist =	dao.isProductExist(code);
	if (exist == false ) {
		status.setCode(200);
		status.setDescripcion("El producto no existe   ");
		return  status;
	}else {
		//status 
		System.out.println("el producto ya se elimino  " );
		//Status status = new Status();
		dao.deleteProducts(connection , code);
		status.setCode(400);
		status.setDescripcion("el producto se elimino   ");
		return  status;
	}
		}   
	 catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error en conection data base" + " - " + e);
		e.printStackTrace();
		status.setCode(500);
		status.setDescripcion("Error en la creacion del producto ");
		return  status;
	}
	
		 
		}
	}
	


