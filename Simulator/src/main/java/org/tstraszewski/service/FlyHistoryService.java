package org.tstraszewski.service;

import java.util.List;

import org.tstraszewski.dao.FlyHistoryDAOImpl;
import org.tstraszewski.model.FlyHistoryEntity;

public interface FlyHistoryService extends BaseService<FlyHistoryDAOImpl, FlyHistoryEntity> {

	
	public List<Integer> getByUserId(int userId);
}
