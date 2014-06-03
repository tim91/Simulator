package org.tstraszewski.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tstraszewski.dao.BaseDAOImpl;
import org.tstraszewski.model.BaseEntity;

@Service
@Transactional
public abstract class BaseServiceImpl<T extends BaseDAOImpl<S>, S extends BaseEntity> implements BaseService<T,S> {

	@Autowired
	protected T dao;

	public int add(S u) {
		return this.dao.add(u);
	}

	public void delete(S u) {
		this.dao.delete(u);
	}

	public List<S> getAll() {
		return this.dao.getAll();
	}
	
	public S getById(int id){
		return this.dao.getById(id);
	}
}
