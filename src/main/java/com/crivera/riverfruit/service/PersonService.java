package com.crivera.riverfruit.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.crivera.riverfruit.model.Person;
import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.ResponsePerson;
import com.crivera.riverfruit.model.ResponseProduct;
import com.crivera.riverfruit.model.ResponseProductList;
import com.crivera.riverfruit.model.Status;
import com.crivera.riverfruit.util.ResponPersonUtil;

public class PersonService {
	// mapProduct.put(product.getCode(), product);
		 //Product product = mapProduct.get(code);
		 //Product product = mapProduct.get(code);
	//Map<String, Person> mapPerson = new HashMap<>();
	 
		//Person personaDefecto = new Person();
		// Map<String, Person> mapaPersonas = new TreeMap<>();
		// mapaPersonas.put("1030642757", personaDefecto );
		//String keySearch ="1030642757";
		
	//	PersonService servicePersona = new PersonService();
		//ResponsePerson respuesta = servicePersona.getPerson(mapaPersonas, keySearch);
		//System.out.println(respuesta.toString());
	
	/**
	 * Metodo que consulta una persona por llave
	 * @author CRIVERA
	 * @param mapPerson
	 * @param key  llave por la que voy a bucar
	 * @return datos de la persona si la llave existe
	 */
	public ResponsePerson getPerson( Map<String, Person> mapPerson, String key){
		System.out.println("consultar persona con id;"+ key);
		 //consultar por llave
	
	Person persona= mapPerson.get(key);
		if( persona!= null) {
			
			ResponPersonUtil responsePersonUtil = new ResponPersonUtil();
        	ResponsePerson  responsePerson =  responsePersonUtil.buildPerson(200, "consulta exitosa", persona);
			 return responsePerson;
		}else {
			System.out.println("la persona con id "+ key + " no existe");	
			
			ResponPersonUtil responsePersonUtil = new ResponPersonUtil();
        	ResponsePerson  responsePerson =  responsePersonUtil.buildPerson(1200, "persona no existe", persona);
			  return responsePerson;
		}

	}
	public ResponsePerson postPerson(Map<String, Person> mapPerson,Person person){
	
		//validar si la llave ya existe
		//devuelve un bolean 
		if(mapPerson.containsKey(person.getIdentificacion())) {
			 //Status status = new Status();
			 //status.setCode(1200);
			 //status.setDescripcion(" ya existe la key ");
			 //ResponsePerson responsePerson = new ResponsePerson();
			 //responsePerson.setStatus(status);
			ResponPersonUtil responsePersonUtil = new ResponPersonUtil();
        	ResponsePerson  responsePerson =  responsePersonUtil.buildPerson(1200, "YA EXISTE LA KEY ", person);
			  return responsePerson;
		}else {
			mapPerson.put(person.getIdentificacion(), person);
			 //Status status = new Status();
			 //status.setCode(200);
			 //status.setDescripcion("persona adicionada al mapa");
			 //ResponsePerson responsePerson = new ResponsePerson();
			 //responsePerson.setStatus(status);
			/// responsePerson.setPerson(person);
			ResponPersonUtil responsePersonUtil = new ResponPersonUtil();
        	ResponsePerson  responsePerson =  responsePersonUtil.buildPerson(200, "Persona adicionada al mapa ", person);
			  return responsePerson;
			
		}
		
	}
	public ResponsePerson deletePerson(Map<String, Person> mapPerson, String identificacion) {
		Person person = mapPerson.get(identificacion);
            if (person != null) {
            	//la persona existe 
            	mapPerson.remove(identificacion);
            	ResponPersonUtil responsePersonUtil = new ResponPersonUtil();
            	ResponsePerson  responsePerson =  responsePersonUtil.buildPerson(200, "persona adicionada a sido eliminada", null);
                return responsePerson ;

			} else {
				
				
				// Status status = new Status();
    		//	 status.setCode(200);
    		///	 status.setDescripcion("la persona no existe ");
    			// ResponsePerson responsePerson = new ResponsePerson();
    			// responsePerson.setStatus(status);
				ResponPersonUtil responsePersonUtil = new ResponPersonUtil();
				ResponsePerson responsePerson = responsePersonUtil.buildPerson(200,"la persona no existe", person);
    			  return responsePerson;
				
			}
	}
	public ResponsePerson modificarPerson(Map<String, Person> mapPerson, String identificacion, Person person) {
	Person personModificar = mapPerson.get(identificacion);
		
	if(	mapPerson.containsKey(identificacion)) {
		mapPerson.replace(identificacion,  person);
		ResponPersonUtil responsePersonUtil = new ResponPersonUtil();
    	ResponsePerson  responsePerson =  responsePersonUtil.buildPerson(200, "persona adicionada a sido eliminada", person);
        return responsePerson ;
	}else {
		ResponPersonUtil responsePersonUtil = new ResponPersonUtil();
		ResponsePerson responsePerson = responsePersonUtil.buildPerson(200,"la persona no existe", person);
		  return responsePerson;
	}
		

	}
	
	
	public int sumaNumero (int num1 , int num2) {
		return num1 + num2;
		
	}
	
	
	
	
	
	
	

}
