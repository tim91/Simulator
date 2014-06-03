package org.tstraszewski.controller;

import java.util.List;

import org.tstraszewski.model.FlyHistoryEntity;

public interface FlyHistoryController {

	public void addHistory(FlyHistoryEntity fhe);
	public void deleteHistory(FlyHistoryEntity fhe);
	public List<FlyHistoryEntity> getAll();
	public FlyHistoryEntity getById(int id);
	public String getByIdAndPlay(int id);
}
