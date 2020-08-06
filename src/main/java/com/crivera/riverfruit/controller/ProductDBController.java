package com.crivera.riverfruit.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.crivera.riverfruit.dao.ProductDao;
import com.crivera.riverfruit.entidad.ProductEntity;
import com.crivera.riverfruit.model.GroupProduct;
import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.ResponseProduct;
import com.crivera.riverfruit.model.Status;
import com.crivera.riverfruit.service.ProductService;
import com.crivera.riverfruit.service.ProductServiceBD;
import com.crivera.riverfruit.util.DbUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

//servicio web de consultar prducto en base de datos 
@Path("/productDB")
public class ProductDBController {
	
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/productsDB")
     public Response getProducts(){
	    	ProductService serviceGet = new ProductService();
	    	List<Product> listProduct = serviceGet.getProductsBD();
		 Gson jsonConverter = new GsonBuilder().create();//clase json 
	 return Response.status(200).entity(jsonConverter.toJson(listProduct)).type(MediaType.APPLICATION_JSON).build();
		
		}
//servico , post (recibe un producto )verificar si ya existe el codigo en base de datos , si no existe guardarlo , si ya existe retorna en status (400)
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/productsPostBD")
    public Response saveProduct(Product product) {
     ProductDao Dao = new  ProductDao();
     List<Product> listProduct;
	try {
		listProduct = Dao.getProducts();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//for(Product i :listProduct) {
		Dao.isProductExist(product.getCode());//compara por el codigo 
		return null;
        	
	}
	
   //  Dao.i//sProductExist(product.getCode());//compara por el codigo 
        
       // Gson jsonConverter = new GsonBuilder().create();

     
      //  return Response.status(200).entity(jsonConverter.toJson(listProduct)).type(MediaType.APPLICATION_JSON).build();

   // }
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/productsPostBD1")
    public Response saveProductBD(ProductEntity productEntity) {
		  Status status = new Status();
		ProductServiceBD productBD = new ProductServiceBD();
		status=	productBD.postProductBD(productEntity);
	


	Gson jsonConverter = new GsonBuilder().create();
    return Response.status(200).entity(jsonConverter.toJson(status)).type(MediaType.APPLICATION_JSON).build();
    }
	//modifiar 5 de agosto 
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/productsPutBD/{id}")
    public Response updateProduct(@PathParam("id")  String code, ProductEntity productEntity) {
        //System.out.println("code" + code);
        //System.out.println("code ELIMINAR:  " + code);
        Status status = new Status();
		ProductServiceBD productBD = new ProductServiceBD();
		status=	productBD.putProductBD(code, productEntity);
        
	 Gson jsonConverter = new GsonBuilder().create();//clase json 

        return Response.status(200).entity(jsonConverter.toJson(status)).build();
    }
    
	//delete 5 de agosto
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/productsDeleteBD/{id}")
    public Response deleteProduct(@PathParam("id")  String code) {
        System.out.println("code ELIMINAR:  " + code);
        
        Status status = new Status();
      		ProductServiceBD productBD = new ProductServiceBD();
      		status=	productBD.deleteProductBD(code);
        //getProduct(listProduct, code);
    	//ProductService serviceDelete = new ProductService();
    	//ResponseProduct responseProduct	= serviceDelete.deleteProduct(listProduct, code);
	 //crear variable para que guarde la variable 
	 Gson jsonConverter = new GsonBuilder().create();//clase json 

        return Response.status(200).entity(jsonConverter.toJson(status)).build();

    }
	
}
