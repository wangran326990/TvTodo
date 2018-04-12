package com.tvtodo.api;

import java.util.List;

import com.tvtodo.models.Season;

public interface ITvSeasonAPI {
	public String listSeasonsJsonResultByShowId(int sid);
	
	public List<Season> listSeasonsByShowId(int sid);
	
	
}
