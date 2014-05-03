package org.tstraszewski.service;

import java.util.List;

import org.tstraszewski.model.UserEntity;

public interface UserService {
	
	public void addUser(UserEntity u);
	public void deleteUser(UserEntity u);
	public List<UserEntity> getAllUsers();
}
