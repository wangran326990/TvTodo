package com.tvtodo.api;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.tvtodo.models.Episode;

public class TvScheduledAPITest {

	ITvScheduledAPI tvScheduledAPI = TvTodoAPIFactory.getTvScheduledAPI();
	
	@Test
	public void testGetNewEpisodesTodayJsonResult() {
		System.out.println(tvScheduledAPI.getNewEpisodesTodayJsonResult());
	}

	@Test
	public void testListNewEpisodesByDateJsonResult() {
		Date date = new Date();
		System.out.println(tvScheduledAPI.listNewEpisodesByDateJsonResult(date));
	}

	@Test
	public void testListNewEpisodesByCountryAndDateJsonResult() {
		Date date = new Date();
		String country ="US";
		System.out.println(tvScheduledAPI.listNewEpisodesByCountryAndDateJsonResult(date, country));
	}

	@Test
	public void testGetNewEpisodesToday() {
		List<Episode> episodes = tvScheduledAPI.getNewEpisodesToday();
		System.out.println(episodes);		
	}

	@Test
	public void testListNewEpisodesByDate() {
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse("2014-11-01");
			System.out.println(tvScheduledAPI.listNewEpisodesByDate(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testListNewEpisodesByCountryAndDate() {
		Date date;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse("2014-11-01");
			System.out.println(tvScheduledAPI.listNewEpisodesByCountryAndDate(date, "AU"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
