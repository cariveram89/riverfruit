package com.crivera.riverfruit.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.crivera.riverfruit.model.Person;
import com.crivera.riverfruit.model.ResponsePerson;
public class PersonServiceTest {
	

	   @Test
	    public void returnSumSuccesfulWithResponse3() {

	        PersonService productService = new PersonService();
	        int sum = productService.sumaNumero (1,2);

	       // assertEquals(3, sum);//metodo prueba unitaria
	        //en el primee campo se colca la respuesta que se debe obtener ,
	        //en el otro campo se coloca la varible en la cual esta almacenada la variable
	        
	        assertEquals(3, sum);
	    }
	   
	   @Test
	   public void  getPersonSuccesful() {
		   
		   //instancia 
		   PersonService productService = new PersonService();
		   ResponsePerson response = new ResponsePerson();
		   Map<String, Person> map2 = buildMapPerson();
		   
		   response = productService.getPerson(map2,"1030889" );
		   //por cada variable 
		   assertEquals("jose", response.getPerson().getNombre());
		   assertEquals("1030889",response.getPerson().getIdentificacion());
		   assertNull(response.getPerson().getFechaNacimiento());
		   assertEquals("consulta exitosa",response.getStatus().getDescripcion());
		   assertEquals(200,response.getStatus().getCode());
		   
	   }
	   //hace que re ejecute la prueba 
	   @Test
	   public void getPersonNoExist() {
		   PersonService productService = new PersonService();
		   ResponsePerson response = new ResponsePerson();
		   Map<String, Person> map2 = buildMapPerson();
		   response = productService.getPerson(map2,"889");
		   //por cada variable 
		   assertNull( response.getPerson());
		  assertEquals("persona no existe",response.getStatus().getDescripcion());
		   assertEquals(1200,response.getStatus().getCode());
		   
	   }
	   //metodo de ayuda 
	   public Map<String, Person> buildMapPerson( ){
		   Person person = new Person("1030", "carlos",null);
		   Person person1 = new Person("1030889", "jose",null);
		  Map<String, Person> mapPerson = new HashMap<>();  
		   mapPerson.put("1030", person);
		   mapPerson.put("1030889", person1);
		   return mapPerson;
	   }
	   
	  

}
