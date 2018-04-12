package com.tvtodo.api;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tvtodo.models.Cast;
import com.tvtodo.models.Crew;
import com.tvtodo.models.Show;

public class TvShowAPITest {
	
	
	
	@Test
	public void testsearchShowJsonResultByName() {
		ITvShowAPI tvShowAPI = TvTodoAPIFactory.getTvShowAPI();
		System.out.println(tvShowAPI.searchShowJsonResultByName("girl"));
	}
	
	@Test
	public void testSearchShowByName(){
		ITvShowAPI tvShowAPI = TvTodoAPIFactory.getTvShowAPI();
		Show show = tvShowAPI.searchShowByName("jifewojfieo");
		System.out.println(show);
	}
	
	@Test
	public void testSearchShowsByName(){
		ITvShowAPI tvShowAPI = TvTodoAPIFactory.getTvShowAPI();
		List<Show> shows =tvShowAPI.searchShowsByName("qfwefkowefpqkeopfwkeofpwkqfpwkefowefkwepfkowp");
		System.out.println(shows);
	}
	@Test
	public void testGetPaginationList(){
		int pnum = 1;
		ITvShowAPI tvShowAPI = TvTodoAPIFactory.getTvShowAPI();
		List<Show> shows = tvShowAPI.getPaginationList(pnum);
		System.out.println(shows);
	}
	
	@Test
	public void testGetCastList(){
		int sid =1000000000;
		ITvShowAPI tvShowAPI = TvTodoAPIFactory.getTvShowAPI();
		List<Cast> casts = tvShowAPI.getCastList(sid);
		System.out.println(casts);
	}
	
	@Test
	public void testGetCrewsList(){
		int sid =1;
		ITvShowAPI tvShowAPI = TvTodoAPIFactory.getTvShowAPI();
		List<Crew> crews = tvShowAPI.getCrewsList(sid);
		System.out.println(crews);
	}

}