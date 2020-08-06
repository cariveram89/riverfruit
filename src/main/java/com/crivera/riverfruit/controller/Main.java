package com.crivera.riverfruit.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.crivera.riverfruit.model.Person;
import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.ResponsePerson;
import com.crivera.riverfruit.model.ResponseProductList;
import com.crivera.riverfruit.model.ResponseProductListOrdered;
import com.crivera.riverfruit.service.PersonService;
import com.crivera.riverfruit.service.ProductService;

public class Main {

	public static void main(String[] args) {
		
		
		
		// Person personaDefecto = new Person();
		// Map<String, Person> mapaPersonas = new TreeMap<>();
		// mapaPersonas.put("1030642757", personaDefecto );
		//String keySearch ="1030642757";
	//int numero=	keySearch.length();
//	System.out.println("cadema"+ numero);
	//	PersonService servicePersona = new PersonService();
		//ResponsePerson respuesta = servicePersona.getPerson(mapaPersonas, keySearch);
		//System.out.println(respuesta.toString());
		
		
		
		// TODO Auto-generated method stub
		//ProductService service = new ProductService();
		
	//	List<Product> listaRecibida = buildListProduct();
	//	ResponseProductList   responseProduct =	service.getProductBuscar(listaRecibida, "M");
	
		//System.out.println(responseProduct);
	
		ProductService service = new ProductService();
		
		List<Product> listaRecibida = buildListProduct();
		//ResponseProductList   responseProduct =	service.getProductBuscar(listaRecibida, "M");
	    ResponseProductList responseProduct = service.getProductListaBuscarFInal(listaRecibida);
		System.out.println(responseProduct.getLista());
		
		
		
		
System.out.print("hola mundo  31");


	}
	
	public static  List<Product> buildListProduct(){
		List<Product> listaProductos= new ArrayList<>();
		Product producto = new Product("mango","M3");
		Product producto2 = new Product("Pitalla","M4");
		Product producto3 = new Product("Naranja","n5");
		Product producto4 = new Product("Melon","M5");
		Product producto5 = new Product("Anon","A5");
		listaProductos.add(producto);
		listaProductos.add(producto2);
		listaProductos.add(producto3);
		listaProductos.add(producto4);
		listaProductos.add(producto5);
		
	//Collections.sort(listaProductos);
		
		return listaProductos;
		
	}
	

}
