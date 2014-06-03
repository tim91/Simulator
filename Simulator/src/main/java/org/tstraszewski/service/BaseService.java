package org.tstraszewski.service;

import java.util.List;

import org.tstraszewski.dao.BaseDAOImpl;
import org.tstraszewski.model.BaseEntity;

public interface BaseService<T extends BaseDAOImpl<S>, S extends BaseEntity> {

	
	public int add(S u);
	public void delete(S u);
	public List<S> getAll();
	public S getById(int id);
}
