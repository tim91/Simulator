package org.tstraszewski.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tstraszewski.model.UserEntity;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

	private static String ALL_USERS_QUERY = "FROM Users";
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addUser(UserEntity u) {
		
		this.sessionFactory.getCurrentSession().save(u);
		this.sessionFactory.getCurrentSession().flush();
	}

	public void deleteUser(UserEntity u) {
		this.sessionFactory.getCurrentSession().delete(u);
	}

	public List<UserEntity> getAllUsers() {
		List l = this.sessionFactory.getCurrentSession().createQuery(ALL_USERS_QUERY).list();
		return l;
	}

}
