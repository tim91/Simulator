package org.tstraszewski.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="FlyHistory")
public class FlyHistoryEntity extends BaseEntity implements Serializable{

	@MapsId @ManyToOne
	private UserEntity userId;
	private String description;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique=true,nullable=false)
	private long id;
	
	public FlyHistoryEntity() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FlyHistoryEntity [id=" + id + ", userId=" + userId
				+ ", description=" + description + "]";
	}
	
	
}
