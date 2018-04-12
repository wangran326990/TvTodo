package com.tvtodo.api;

import java.util.Date;
import java.util.List;

import com.tvtodo.models.Episode;

public interface ITvScheduledAPI {
		public String getNewEpisodesTodayJsonResult();
		
		public String listNewEpisodesByDateJsonResult(Date date);
		
		public String listNewEpisodesByCountryAndDateJsonResult(Date date, String countryCode);
		
		List<Episode> getNewEpisodesToday();
		
		List<Episode> listNewEpisodesByDate(Date date);
		
		List<Episode> listNewEpisodesByCountryAndDate(Date date, String countryCode);
}
