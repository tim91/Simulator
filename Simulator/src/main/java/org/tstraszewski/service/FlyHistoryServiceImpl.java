package org.tstraszewski.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tstraszewski.dao.FlyHistoryDAOImpl;
import org.tstraszewski.model.FlyHistoryEntity;

@Service
@Transactional
public class FlyHistoryServiceImpl extends BaseServiceImpl<FlyHistoryDAOImpl, FlyHistoryEntity>implements FlyHistoryService {

	public List<FlyHistoryEntity> getByUserId(int userId) {

		
		List<FlyHistoryEntity> fl = dao.getByUserId(userId);
		return fl;
	}

}
