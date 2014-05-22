package org.tstraszewski.service;

import org.tstraszewski.dao.UserDAOImpl;
import org.tstraszewski.model.UserEntity;

public interface UserService extends BaseService<UserDAOImpl, UserEntity> {
	
	public UserEntity getByName(String name);
}
