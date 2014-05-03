package org.tstraszewski.controller;

import java.util.List;

import org.tstraszewski.model.UserEntity;

public interface UserController {

	public void addUser(UserEntity u);
	public void deleteUser(UserEntity u);
	public List<UserEntity> getAllUsers();
}
