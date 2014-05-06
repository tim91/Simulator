package org.tstraszewski.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tstraszewski.dao.FlyHistoryDAOImpl;
import org.tstraszewski.model.FlyHistoryEntity;

@Service
@Transactional
public class FlyHistoryServiceImpl extends BaseServiceImpl<FlyHistoryDAOImpl, FlyHistoryEntity>implements FlyHistoryService {

}
