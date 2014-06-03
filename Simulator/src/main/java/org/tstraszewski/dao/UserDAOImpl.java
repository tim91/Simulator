package org.tstraszewski.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tstraszewski.model.UserEntity;

@Repository("userDAO")
public class UserDAOImpl extends BaseDAOImpl<UserEntity> implements UserDAO {

	/*
	 * Zobaczyc JPA
	 */
	private static String ALL_USERS_QUERY = "from UserEntity";
	
	public UserDAOImpl() {
		super(ALL_USERS_QUERY,"UserEntity");
	}

	public UserEntity getUserByName(String nickName) {
		
		List<UserEntity> li = sessionFactory.getCurrentSession().createQuery("from UserEntity where nickName = '" + nickName + "'").list();
		if(li.size() >0){
			return li.get(0);
		}else{
			return null;
		}
	}


}
