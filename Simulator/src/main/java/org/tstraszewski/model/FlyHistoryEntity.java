package org.tstraszewski.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@SequenceGenerator(initialValue = 1, name="baseSequence", sequenceName = "fly_history_sequence")
@Table(name="FlyHistory")
public class FlyHistoryEntity extends BaseEntity implements Serializable{
	
	@ManyToOne
	private UserEntity user;
	private float posX;
	private float posY;
	private float posZ;
	private float velX;
	private float velY;
	private float velZ;
	
	private long timeLong;
	
	public FlyHistoryEntity() {
		System.out.println("konstruktor: FlyHistoryEntity");
		this.timeLong = System.currentTimeMillis();
	}

	@JsonIgnore
	public UserEntity getUserId() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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

	@JsonProperty("timeLong")
	public long getTimeLong() {
		return timeLong;
	}

	@JsonIgnore
	public void setTimeLong(long timeLong) {
		System.out.println("Przed ustawienie timeLong: " + this.timeLong);
		this.timeLong = timeLong;
	}

	@Override
	public String toString() {
		return "FlyHistoryEntity [user=" + user + ", posX=" + posX
				+ ", posY=" + posY + ", posZ=" + posZ + ", velX=" + velX
				+ ", velY=" + velY + ", velZ=" + velZ + ", timeLong="
				+ timeLong + "]";
	}

}
