package org.tstraszewski.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.tstraszewski.model.FlyHistoryEntity;

@Repository("flyHistoryDAO")
public class FlyHistoryDAOImpl extends BaseDAOImpl<FlyHistoryEntity> implements FlyHistoryDAO {

	private static String ALL_FLY_HISTORY_QUERY = "FROM FlyHistoryEntity";
	
	private static String GET_BY_USER_ID = "select id FROM FlyHistoryEntity where user_id = '%s'";
	
	public FlyHistoryDAOImpl() {
		super(ALL_FLY_HISTORY_QUERY);
	}

	public List<Integer> getByUserId(int userId) {

		String s = String.format(GET_BY_USER_ID, userId);
		System.out.println(s);
		return (List<Integer>) sessionFactory.getCurrentSession().createQuery(s).list();
	}

}
