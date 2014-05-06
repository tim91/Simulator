package org.tstraszewski.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tstraszewski.model.BaseEntity;


@Repository("baseDAO")
public abstract class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {

	
	@Autowired
	protected SessionFactory sessionFactory;
	
	private String getAllQuery = null;
	
	public BaseDAOImpl(String getAllQuery) {
		this.getAllQuery = getAllQuery;
	}
	
	public void add(T u) {
		this.sessionFactory.getCurrentSession().save(u);
	}

	
	public void delete(T u) {
		this.sessionFactory.getCurrentSession().delete(u);
	}
	
	public List<T> getAll() {
		List l = this.sessionFactory.getCurrentSession().createQuery(this.getAllQuery).list();
		return l;
	}
}

