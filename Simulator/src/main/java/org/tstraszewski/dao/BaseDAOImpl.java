package org.tstraszewski.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tstraszewski.model.BaseEntity;


@Repository("baseDAO")
public abstract class BaseDAOImpl<T extends BaseEntity> implements BaseDAO<T> {
	
	@Autowired
	protected SessionFactory sessionFactory;
	
	private String getAllQuery = null;
	
	private String className;
	
	public BaseDAOImpl(String getAllQuery,String className) {
		this.getAllQuery = getAllQuery;
		this.className = className;
	}
	
	public int add(T u) {
		Serializable s = this.sessionFactory.getCurrentSession().save(u);
		return (Integer)s;
	}

	
	public void delete(T u) {
		this.sessionFactory.getCurrentSession().delete(u);
	}
	
	public List<T> getAll() {
		List<T> l = this.sessionFactory.getCurrentSession().createQuery(this.getAllQuery).list();
		return l;
	}
	
	public T getById(int id){
		String query = "FROM " + this.className + " where id=" + id;
		List<T> l = this.sessionFactory.getCurrentSession().createQuery(query).list();
		if(l.size() > 0){
			return l.get(0);
		}
		return null;
	}
}

