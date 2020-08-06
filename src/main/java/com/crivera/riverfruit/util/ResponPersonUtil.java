package com.crivera.riverfruit.util;

import com.crivera.riverfruit.model.Person;
import com.crivera.riverfruit.model.Product;
import com.crivera.riverfruit.model.ResponsePerson;
import com.crivera.riverfruit.model.Status;

public class ResponPersonUtil {
	
	public ResponsePerson buildPerson(Integer statusCode, String statusDescricion, Person person ) {
		Status status = new Status();
		 status.setCode(statusCode);
		 status.setDescripcion(statusDescricion);
		
	return new ResponsePerson(person,status);
	}

}
