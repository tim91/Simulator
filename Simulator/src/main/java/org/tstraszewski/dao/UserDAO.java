package org.tstraszewski.dao;

import java.util.List;

import org.tstraszewski.model.UserEntity;

public interface UserDAO {

	public void addUser(UserEntity u);
	public void deleteUser(UserEntity u);
	public List<UserEntity> getAllUsers();
}
