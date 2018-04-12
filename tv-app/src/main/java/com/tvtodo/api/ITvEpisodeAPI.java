package com.tvtodo.api;

import java.util.List;

import com.tvtodo.models.Episode;

public interface ITvEpisodeAPI {
	public String listEpisodeJsonResultBySeasonId(int sid);
	
	public List<Episode> listEpisodeResultBySeasonId(int sid);
	
	public List<Episode> listEpisodeResultByShowIdAndAirdate(int sid, String Date); 
	
}
