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
	private int posX;
	private int posY;
	private int posZ;
	private int velX;
	private int velY;
	private int velZ;
	
	public FlyHistoryEntity() {
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosZ() {
		return posZ;
	}

	public void setPosZ(int posZ) {
		this.posZ = posZ;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getVelZ() {
		return velZ;
	}

	public void setVelZ(int velZ) {
		this.velZ = velZ;
	}

	@Override
	public String toString() {
		return "FlyHistoryEntity [userId=" + userId + ", posX=" + posX
				+ ", posY=" + posY + ", posZ=" + posZ + ", velX=" + velX
				+ ", velY=" + velY + ", velZ=" + velZ + "]";
	}

	
	
	
}
