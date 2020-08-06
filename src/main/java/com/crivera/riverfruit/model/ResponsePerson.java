package com.crivera.riverfruit.model;

public class ResponsePerson {
	private Status status;
	private Person  person;
	public ResponsePerson() {
		
	}
	public ResponsePerson(Status status) {
			
			this.status = status;
		}
	
	public ResponsePerson(Person person, Status status) {
		this.person = person;
		this.status = status;
	}
	

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}



}
