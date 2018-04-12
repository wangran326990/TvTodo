package com.tvtodo.api;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.tvtodo.models.Season;


public class TvSeasonAPITest {

	private ITvSeasonAPI tvSeasonAPI = TvTodoAPIFactory.getTvSeasonAPI();
	
	@Test
	public void testListSeasonsJsonResultByShowId() {
		int sid = 1;
		String json=tvSeasonAPI.listSeasonsJsonResultByShowId(sid);
		System.out.println(json);
	}

	@Test
	public void testListSeasonsByShowId() {
		int sid = 1;
		List<Season> list = tvSeasonAPI.listSeasonsByShowId(sid);
		System.out.println(list);
	}
	
	
}
