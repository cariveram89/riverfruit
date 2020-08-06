package com.crivera.riverfruit.controller;

import java.util.HashMap;
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

import com.crivera.riverfruit.model.CrearPersona;
import com.crivera.riverfruit.model.Person;
import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.ResponsePerson;
import com.crivera.riverfruit.model.ResponseProduct;
import com.crivera.riverfruit.model.ResponseProductList;
import com.crivera.riverfruit.service.PersonService;
import com.crivera.riverfruit.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Path("/person")
public class PersonController {
	private static Map<String, Person> mapPerson = new HashMap<>();
	Gson jsonConverter = new GsonBuilder().create();//clase json 
	// mapProduct.put(product.getCode(), product);
	 //Product product = mapProduct.get(code);
	 //Product product = mapProduct.get(code);
	
	 @GET
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/personaGet/{id}")
		public Response personaTarea3(@PathParam("id")  String id){
			
		//System.out.println("consultar fruta con id;"+ code);	
	    	
	    	PersonService serviceGet = new PersonService();
	    	ResponsePerson responsePersonGet	= serviceGet.getPerson(mapPerson, id);
		 //crear variable para que guarde la variable 
		
		 
			    ////
		
	return Response.status(200).entity(jsonConverter.toJson(responsePersonGet)).build();

}
	    @POST
	    @Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/personPostT/")
		public Response personaTarea3(Person person){
              System.out.println("Inicio Post crear persona");
	    	PersonService servicePost = new PersonService();
	    	ResponsePerson servicioPersonaPost = servicePost.postPerson(mapPerson, person);
	    	 
			    return Response.status(200).entity(jsonConverter.toJson(servicioPersonaPost)).type(MediaType.APPLICATION_JSON).build();
			 }
	    
	    
	    @DELETE
	    @Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/personDelete/{id}")
		public Response personaTarea4(@PathParam("id")  String code){
              System.out.println("Inicio Post crear persona");
	    	PersonService servicePost = new PersonService();
	    	ResponsePerson servicioPersonaPost = servicePost.deletePerson(mapPerson, code);
	    	 
			    return Response.status(200).entity(jsonConverter.toJson(servicioPersonaPost)).type(MediaType.APPLICATION_JSON).build();
			 }
	    
	    @PUT
	    @Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		@Path("/personPut/{id}")
		public Response personaTarea5(@PathParam("id")  String code, Person person){
              System.out.println("Inicio Post crear persona");
	    	PersonService servicePost = new PersonService();
	    	ResponsePerson servicioPersonaPost = servicePost.modificarPerson(mapPerson,code , person);
	    	 
			    return Response.status(200).entity(jsonConverter.toJson(servicioPersonaPost)).type(MediaType.APPLICATION_JSON).build();
			 }
	    
	    
	    
	    
}
	 
