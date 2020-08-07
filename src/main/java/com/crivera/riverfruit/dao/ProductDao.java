package com.crivera.riverfruit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crivera.riverfruit.entidad.ProductEntity;
import com.crivera.riverfruit.entidad.Resolution;
import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.util.DbUtil;

public class ProductDao {
	//obtiene la lista de productos de la base de datos 
	public List<Product> getProducts() throws SQLException {
		DbUtil baseDeDatos = new DbUtil();
		Connection con = baseDeDatos.connectionDb();
		String query = "SELECT code, name, price FROM product";
		List<Product> listProduct = new ArrayList<>();
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			Product product = new Product();
			product.setCode(resultSet.getString("code"));
			product.setName(resultSet.getString("name"));
			listProduct.add(product);
		}
		return 	listProduct;
		
	}
	public boolean  isProductExist(String code) {
		//atrapar la expecion 
		DbUtil baseDeDatos = new DbUtil();
		Connection con = baseDeDatos.connectionDb();
		String query = "SELECT code  FROM product where code= "+"'"+code+"'";
		Statement statement;
		try {
			statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()== false) {
				System.out.println("try if " );
				return false;
				
				//System.out.println("if del try ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("catch " );
			e.printStackTrace();
			return false;
		}
		System.out.println("retorna true catch " );
		return 	true;
	}
	public void postProducts(Connection conn) throws SQLException {
		
		DbUtil dbUtil = new DbUtil();
		conn = dbUtil.connectionDb();
		Statement statement = conn.createStatement();

		//insert 
		String queryInsert = " INSERT INTO product (code, name, price) VALUES ('T1','Tomate', '000')";
		statement.executeUpdate(queryInsert );//code , name ;000
		//hacer una excepcion 
	}
	public void deleteProducts(Connection conn, String code) throws SQLException {
		
		DbUtil dbUtil = new DbUtil();
		conn = dbUtil.connectionDb();
		Statement statement = conn.createStatement();
		StringBuilder queryBuilder  = new StringBuilder();
		queryBuilder.append(" DELETE FROM Product where code='")
				.append(code).append("'");
		String queryInsert =queryBuilder.toString();;
		statement.executeUpdate(queryInsert );//code , name ;000
		//hacer una excepcion 
	}
	public void postProducts1(Connection conn, ProductEntity product) throws SQLException {
		
		DbUtil dbUtil = new DbUtil();
		conn = dbUtil.connectionDb();
		Statement statement = conn.createStatement();
		//insert 
		StringBuilder queryBuilder  = new StringBuilder();
		queryBuilder.append(" INSERT INTO product (code, name, price) VALUES ('")
		.append(product.getCode()).append("','")
		.append(product.getName()).append("', '")
		.append(product.getPrice()).append("')");
		String queryInsert =queryBuilder.toString();
		//String queryInsert = " INSERT INTO product (code, name, price) VALUES ('T1','Tomate', '000')";
		
		statement.executeUpdate(queryInsert );//code , name ;000
		//sive para adicionar informacion 
		//hacer una excepcion 

	}
	public void putProducts1(Connection conn, ProductEntity product,String code) throws SQLException {
		//git basch , mi primer commit solo
		//mi segundo commit
		DbUtil dbUtil = new DbUtil();
		conn = dbUtil.connectionDb();
		Statement statement = conn.createStatement();
		//insert 
		StringBuilder queryBuilder  = new StringBuilder();
		queryBuilder.append(" UPDATE Product SET name = '")
		.append(product.getName()).append("', price= '")
		.append(product.getPrice()).append("' WHERE code ='")
		.append(code).append("'");
		String queryUpdate =queryBuilder.toString();
		System.out.println("Query: " +queryUpdate );
		//String queryInsert = " INSERT INTO product (code, name, price) VALUES ('T1','Tomate', '000')";
		
		statement.executeUpdate(queryUpdate );//code , name ;000
		//sive para adicionar informacion 
		//hacer una excepcion 
	}
}

