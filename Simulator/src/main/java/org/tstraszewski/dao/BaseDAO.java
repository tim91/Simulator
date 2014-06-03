package org.tstraszewski.dao;

import java.util.List;

import org.tstraszewski.model.BaseEntity;

public interface BaseDAO<T extends BaseEntity> {

	public void add(T u);
	public void delete(T u);
	public T getById(int id);
	public List<T> getAll();
}
