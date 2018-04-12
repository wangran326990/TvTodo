package com.tvtodo.api;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tvtodo.models.Episode;
import com.tvtodo.models.Season;

public class TvScheduledAPI implements ITvScheduledAPI {
	
	private RestTemplate restTemplate;
	private static TvScheduledAPI TvScheduledAPI = null;
	private static final String url = "http://api.tvmaze.com/";
	private  TvScheduledAPI() {
		
	}
	
	private  TvScheduledAPI(RestTemplate restTemplate) {
			this.restTemplate = restTemplate;
	}
	
	public static synchronized TvScheduledAPI getInstance(RestTemplate restTemplate) {
		if(TvScheduledAPI==null){
			TvScheduledAPI = new TvScheduledAPI(restTemplate);
		}
		return TvScheduledAPI;
	}
	
	@Override
	public String getNewEpisodesTodayJsonResult() {
		String urlString = url +"schedule";
		try {
			return restTemplate.getForObject(urlString, String.class, 200);
		} catch (Exception e) {
			return "[]";
		}
		
	}

	@Override
	public String listNewEpisodesByDateJsonResult(Date date) {
		String urlString = url +"schedule?";
		urlString = urlBuilder(urlString, date,null);
		try {
			return restTemplate.getForObject(urlString, String.class, 200);
		} catch (Exception e) {
			return "[]";
		}
	}

	@Override
	public String listNewEpisodesByCountryAndDateJsonResult(Date date, String countryCode) {
		String urlString = url +"schedule?";
		urlString = urlBuilder(urlString, date, countryCode);
		try {
			return restTemplate.getForObject(urlString, String.class, 200);
		} catch (Exception e) {
			return "[]";
		}
	}

	@Override
	public List<Episode> getNewEpisodesToday() {
		String json = this.getNewEpisodesTodayJsonResult();
		Type listType =new TypeToken<ArrayList<Episode>>(){}.getType();
		List<Episode> list = new Gson().fromJson(json, listType);
		return list;
	}

	@Override
	public List<Episode> listNewEpisodesByDate(Date date) {
		String json = this.listNewEpisodesByDateJsonResult(date);
		Type listType = new TypeToken<ArrayList<Episode>>(){}.getType();
		List<Episode> list = new Gson().fromJson(json, listType);
		return list;
	}

	@Override
	public List<Episode> listNewEpisodesByCountryAndDate(Date date, String countryCode) {
		String json = this.listNewEpisodesByCountryAndDateJsonResult(date, countryCode);
		Type listType = new TypeToken<ArrayList<Episode>>(){}.getType();
		List<Episode> list = new Gson().fromJson(json, listType);
		return list;
	}
	
	private String urlBuilder(String urlStr, Date date, String countryCode){
		if(date==null && countryCode ==null)
			return urlStr;
		if(date==null){
			return urlStr +"country="+countryCode;
		}else{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = sdf.format(date);
			urlStr = urlStr +"date="+dateString;
			if(countryCode!=null){
				urlStr =urlStr +"&country="+countryCode;
			}
			return urlStr;
		}
		
	}

}
