package com.galeapp.views;

import com.galeapp.model.Person;

public class nominateView {
	
	private int id;
    private String nomineePersonId;
	private Person nominatorPerson;
	
    private Person nomineePerson;
	
    private String coreValue;
    private String comments;
    private boolean submitted;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person getNominatorPerson() {
		return nominatorPerson;
	}
	public void setNominatorPerson(Person nominatorPerson) {
		this.nominatorPerson = nominatorPerson;
	}
	public Person getNomineePerson() {
		return nomineePerson;
	}
	public void setNomineePerson(Person nomineePerson) {
		this.nomineePerson = nomineePerson;
	}
	public String getCoreValue() {
		return coreValue;
	}
	public void setCoreValue(String coreValue) {
		this.coreValue = coreValue;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public boolean isSubmitted() {
		return submitted;
	}
	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	public String getNomineePersonId() {
		return nomineePersonId;
	}
	public void setNomineePersonId(String nomineePersonId) {
		this.nomineePersonId = nomineePersonId;
	}
}
