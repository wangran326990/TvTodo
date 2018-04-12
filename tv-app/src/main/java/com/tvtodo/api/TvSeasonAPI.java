package com.tvtodo.api;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tvtodo.models.Season;
import com.tvtodo.models.ShowWithScore;

public class TvSeasonAPI implements ITvSeasonAPI {

	
	private RestTemplate restTemplate;
	private static TvSeasonAPI tvSeasonAPI = null;
	private static final String url = "http://api.tvmaze.com/";
	private  TvSeasonAPI() {
		
	}
	
	private  TvSeasonAPI(RestTemplate restTemplate) {
			this.restTemplate = restTemplate;
	}
	
	public static synchronized TvSeasonAPI getInstance(RestTemplate restTemplate) {
		if(tvSeasonAPI==null){
			tvSeasonAPI = new TvSeasonAPI(restTemplate);
		}
		return tvSeasonAPI;
	}
	
	@Override
	public String listSeasonsJsonResultByShowId(int sid) {
		String urlString = url+"shows/"+sid+"/seasons";
		String seasonsList;
		try {
			seasonsList = this.restTemplate.getForObject(urlString, String.class, 200);
		} catch (HttpClientErrorException e) {
			seasonsList ="[]";
		}
		
		return seasonsList;
	}

	@Override
	public List<Season> listSeasonsByShowId(int sid) {
		String json =this.listSeasonsJsonResultByShowId(sid);
		Type listType =new TypeToken<ArrayList<Season>>(){}.getType();
		List<Season> list = new Gson().fromJson(json, listType);
		return list;
	}

}
