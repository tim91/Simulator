package org.tstraszewski.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tstraszewski.dao.UserDAO;
import org.tstraszewski.model.UserEntity;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Transactional
	public void addUser(UserEntity u) {
		this.userDAO.addUser(u);
	}

	@Transactional
	public void deleteUser(UserEntity u) {
		this.userDAO.deleteUser(u);
	}

	@Transactional
	public List<UserEntity> getAllUsers() {
		return this.userDAO.getAllUsers();
	}

}
