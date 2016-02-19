package com.galeapp.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
 
/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="NOMINATION")
public class Nomination {
	
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
	private String nominatorPersonId;
	
    private String nomineePersonId;
	
    private String coreValue;
    private String comments;
    private boolean submitted;
    
    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;
    
    public int getId() {
        return id;
    }
 
	public void setId(int id) {
		this.id = id;
	}
	

	public String getNominatorPersonId() {
		return nominatorPersonId;
	}

	public void setNominatorPersonId(String nominatorPersonId) {
		this.nominatorPersonId = nominatorPersonId;
	}

	public String getNomineePersonId() {
		return nomineePersonId;
	}

	public void setNomineePersonId(String nomineePersonId) {
		this.nomineePersonId = nomineePersonId;
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
	
	public boolean getSubmitted() {
		return submitted;
	}

	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}

}
