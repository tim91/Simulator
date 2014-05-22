package org.tstraszewski.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "baseSequence")
    @Column(name = "id", unique=true, nullable=false)
    private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
