package org.tstraszewski.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tstraszewski.model.UserEntity;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<UserEntity> implements UserDAO {

	/*
	 * Zobaczyc JPA
	 */
	private static String ALL_USERS_QUERY = "from UserEntity";
	
	public UserDAOImpl() {
		super(ALL_USERS_QUERY);
	}


}
