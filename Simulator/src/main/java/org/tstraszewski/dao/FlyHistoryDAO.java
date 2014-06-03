package org.tstraszewski.dao;

import java.util.List;

import org.tstraszewski.model.FlyHistoryEntity;


public interface FlyHistoryDAO extends BaseDAO<FlyHistoryEntity> {
	
	public List<FlyHistoryEntity> getByUserId(int userId);
}
