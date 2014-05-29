package org.tstraszewski.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(initialValue = 1, name="baseSequence", sequenceName = "fly_history_sequence")
@Table(name="FlyHistory")
public class FlyHistoryEntity extends BaseEntity implements Serializable{
	
	@ManyToOne
	private UserEntity userId;
	private float posX;
	private float posY;
	private float posZ;
	private float velX;
	private float velY;
	private float velZ;
	
	public FlyHistoryEntity() {
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public float getPosZ() {
		return posZ;
	}

	public void setPosZ(float posZ) {
		this.posZ = posZ;
	}

	public float getVelX() {
		return velX;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public float getVelZ() {
		return velZ;
	}

	public void setVelZ(float velZ) {
		this.velZ = velZ;
	}

	@Override
	public String toString() {
		return "FlyHistoryEntity [userId=" + userId + ", posX=" + posX
				+ ", posY=" + posY + ", posZ=" + posZ + ", velX=" + velX
				+ ", velY=" + velY + ", velZ=" + velZ + "]";
	}
	
}
