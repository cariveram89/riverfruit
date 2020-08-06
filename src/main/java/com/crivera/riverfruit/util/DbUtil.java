package com.crivera.riverfruit.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crivera.riverfruit.dao.ProductDao;
import com.crivera.riverfruit.entidad.Resolution;
import com.crivera.riverfruit.model.Product;

public class DbUtil {
	private String url = "jdbc:postgresql://127.0.0.1:5432/";
	private String dbName = "fruver";
	private String driver = "org.postgresql.Driver";
	private String userName = "postgres";
	private String password = "admin";

	public static void main(String[] args) {
		
		List<Product> listaResolution = new ArrayList<>();
		try {
			DbUtil bd = new DbUtil();
			Connection connection = bd.connectionDb();
			ProductDao dao = new ProductDao();
		  	dao.postProducts(connection);
		    System.out.println("Inserto");
			}   
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en conection data base" + " - " + e);
			e.printStackTrace();
		}
		/*
		dao.isProductExist("D1");
		boolean isproductExist=		dao.isProductExist("D1");
		System.out.println("D1"+ isproductExist);
		boolean isproductExist1=		dao.isProductExist("Df1");
		System.out.println("DF1"+ isproductExist1);
		// TODO Auto-generated method stub
		try {
			DbUtil bd = new DbUtil();
			Connection connection = bd.connectionDb();

			List<Product> productos = bd.getProducts(connection);
			System.out.println("Productos");
			productos.forEach(producto -> {
				System.out.println(producto.toString());
			});

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en conection data base" + " - " + e);
			e.printStackTrace();
	
		}*/
	
}
	public Connection connectionDb() {
		Connection conn = null;
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			if (!conn.isClosed()) {
				System.out.println("Conection open");
			}
		} catch (Exception e) {
			printException(e, "log");
		}
		return conn;
	}

	/// metodo que imprime las excepciones
	private static void printException(Exception e, String log) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String sStackTrace = sw.toString(); // stack trace as a string
		System.out.println(log + " - " + sStackTrace);
	}

	private List<Product> postProducts(Connection conn) throws SQLException {
		
		DbUtil dbUtil = new DbUtil();
		List<Product> listaResolution = new ArrayList<>();
		conn = dbUtil.connectionDb();
		Statement statement = conn.createStatement();
		
			
		//insert 
		String queryInsert = " INSERT INTO product (code, name, price) VALUES ('T1','Tomate', '000')";
		statement.executeUpdate(queryInsert );//code , name ;000
		//hacer una excepcion 
		return listaResolution;

	}

	private List<Product> getProducts(Connection conn) throws SQLException {
		String query = "SELECT code, name, price FROM product";
		DbUtil dbUtil = new DbUtil();
		List<Product> listaResolution = new ArrayList<>();
		conn = dbUtil.connectionDb();
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while (resultSet.next()) {
			Product resolution = new Product();
			resolution.setCode(resultSet.getString("code"));
			resolution.setName(resultSet.getString("name"));
			//resolution.setPrice(resultSet.getLong("price"));
			listaResolution.add(resolution);
			}
			
		//insert 
		//String queryInsert = " INSERT INTO product (code, name, price) VALUES ('D1','Durazno', '3000')";
		//statement.executeUpdate(queryInsert );//code , name ;000
		//hacer una excepcion 
		return listaResolution;

	}

}
