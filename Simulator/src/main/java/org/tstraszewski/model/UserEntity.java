package org.tstraszewski.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@SequenceGenerator(initialValue=1, name="baseSequence", sequenceName = "user_sequence")
@Table(name="Users")
public class UserEntity extends BaseEntity implements Serializable {
	
	@Column(unique=true, nullable=false,length=15)
	@Length(min=4, max=15)
	private String nickName;
	@Column(length=15)
	@Length(min=4, max=15)
	private String firstName;
	@Column(length=15)
	@Length(min=4, max=15)
	private String lastName;
	@Column(length=15,nullable=false)
	@Length(min=6, max=15)
	@JsonIgnore
	private String passwordDigest;
	@Column(length=15,nullable=false)
	@Length(min=6, max=15)
	@JsonIgnore
	private String passwordHashed;


	public UserEntity() {
	}

	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPasswordDigest() {
		return passwordDigest;
	}

	public void setPasswordDigest(String passwordDigest) {
		this.passwordDigest = passwordDigest;
	}

	public String getPasswordHashed() {
		return passwordHashed;
	}

	public void setPasswordHashed(String passwordHashed) {
		this.passwordHashed = passwordHashed;
	}

	@Override
	public String toString() {
		return "UserEntity [nickName=" + nickName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", passwordDigest="
				+ passwordDigest + ", passwordHashed=" + passwordHashed + "]";
	}
	
	
}
