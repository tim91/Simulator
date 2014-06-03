package org.tstraszewski.controller;

import java.util.List;

import org.tstraszewski.model.UserEntity;

public interface UserController {

	public void addUser(UserEntity u);
	public int getUserId();
	public void deleteUser(UserEntity u);
	public List<UserEntity> getAllUsers();
	public UserEntity getById(int id);
	public UserEntity getCurrentLogged();
}
