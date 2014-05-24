package org.tstraszewski.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tstraszewski.dao.UserDAOImpl;
import org.tstraszewski.model.UserEntity;

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDAOImpl, UserEntity> implements UserService {

	public UserEntity getByName(String name) {
		return dao.getUserByName(name);
	}

}
