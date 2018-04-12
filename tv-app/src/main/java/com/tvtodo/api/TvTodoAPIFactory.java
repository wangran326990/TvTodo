package com.tvtodo.api;

import org.springframework.web.client.RestTemplate;

class TvTodoAPIFactory {
	private static final RestTemplate restTemplate = new RestTemplate();
	
	public static ITvShowAPI getTvShowAPI(){
		return TvShowAPI.getInstance(restTemplate);
	}
	
	public static ITvSeasonAPI getTvSeasonAPI(){
		return TvSeasonAPI.getInstance(restTemplate);
	}
	
	public static ITvScheduledAPI getTvScheduledAPI(){
		return TvScheduledAPI.getInstance(restTemplate);
	}
}
