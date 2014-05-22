package org.tstraszewski.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@SequenceGenerator(initialValue=1, name="baseSequence", sequenceName = "user_sequence")
@Table(name="Users")
public class UserEntity extends BaseEntity implements Serializable {
	
	@Column(unique=true, nullable=false)
	private String nickName;
	private String firstName;
	private String lastName;
	@Column(nullable=false)
	@Length(min=6, max=15)
	private String password;


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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserEntity [nickName=" + nickName + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password + ", id="
				+ super.getId() + "]";
	}
}
