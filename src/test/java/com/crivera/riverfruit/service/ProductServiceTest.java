package com.crivera.riverfruit.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.crivera.riverfruit.model.GroupProduct;
import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.ResponseProduct;

public class ProductServiceTest {
	  
	
	
	@Test
	    public void returnSumSuccesfulWithResponse3() {
           //se instancia la clase servicios que es clase donde se van a probar las respectivas funciones 
	        ProductService productService = new ProductService();
	        int resta = productService.restaNumero(10, 8);

	       // assertEquals(3, sum);//metodo prueba unitaria
	        //en el primer campo se colaca la respuesta que debe dar si es correcto el procedimiento 
	        // en el segundo campo se pone la varible en la cual esta siendo guardada la informacion anterior
	        assertEquals(2, resta);
	    }
	  
	  
	  
	  
	  
	  /**
	   * Prueba que:
	   * returma sucessfull producto
	   * @author CRIVERA 
	   */
	  @Test
	    public void returnGetSuccefullProducto() {
	   ProductService productService = new ProductService();
	   ResponseProduct response = new ResponseProduct();
	   List<Product> listProduct =  buildListProduct( );
	  // Map<String, Product> map2 = buildMapProduct();
	   
	   response = productService.getProduct(listProduct, "M1");
	   //por cada variable 
	   assertEquals("M1", response.getProduct().getCode());
	   assertEquals("Manzana",response.getProduct().getName());
	  
	  }
	  
	  
	  
	  
	  
	  // tarea 22 de julio organizar producto con el orden de la primera letra de su codigo 
	  @Ignore
	  @Test
	    public void returnSuccefullProductoOrdanizadoXLaPrimeraLetra() {
	   ProductService productService = new ProductService();
	 ResponseProduct response = new ResponseProduct();
	   List<Product> listProduct =  buildListProduct( );
	   List<GroupProduct> listProductOrganizada = new ArrayList<>();
	  // Map<String, Product> map2 = buildMapProduct();
	   
	   listProductOrganizada = productService.getListProduct(listProduct);
	   //por cada variable que se va a visualizar
	  // assertEquals("M",listProductOrganizada.get)
	   assertEquals("M", listProductOrganizada.get(0).getCode());
	   List<Product> listaProductosMesperados = new ArrayList<>();
	   listaProductosMesperados.add(new Product("Manzana","M1"));
	   listaProductosMesperados.add(new Product("Mango","M2"));
	   assertEquals(listaProductosMesperados, listProductOrganizada.get(0).getProducts());
	  
	  }
	  
	   //metodo de ayuda 
	   public List<Product>   buildListProduct( ){
		   Product product = new Product("Manzana","M1");
		   Product product1 = new Product("Pera","P2");
		   Product product2 = new Product("Mango","M2");
		   List<Product> listProduct = new ArrayList<>();
		//  Map<String, Product> mapProduct = new HashMap<>();  
				   listProduct.add(product); 
				   listProduct.add(product1); 
				   listProduct.add(product2); 

		   return listProduct;
	   }
	   
	   
}
