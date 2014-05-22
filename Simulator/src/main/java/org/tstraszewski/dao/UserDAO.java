package org.tstraszewski.dao;

import org.tstraszewski.model.UserEntity;


public interface UserDAO extends BaseDAO<UserEntity> {
	
	public UserEntity getUserByName(String name);
}
