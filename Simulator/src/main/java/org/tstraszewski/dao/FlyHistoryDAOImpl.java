package org.tstraszewski.dao;

import org.springframework.stereotype.Repository;
import org.tstraszewski.model.FlyHistoryEntity;

@Repository("flyHistoryDAO")
public class FlyHistoryDAOImpl extends BaseDAOImpl<FlyHistoryEntity> implements FlyHistoryDAO {

	private static String ALL_FLY_HISTORY_QUERY = "FROM FlyHistoryEntity";
	
	public FlyHistoryDAOImpl() {
		super(ALL_FLY_HISTORY_QUERY);
	}

}
