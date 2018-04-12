package com.tvtodo.api;

import java.util.List;

import com.tvtodo.models.Cast;
import com.tvtodo.models.Crew;
import com.tvtodo.models.Show;

public interface ITvShowAPI {
		
	public String searchShowJsonResultByName(String name);
	
	public Show searchShowByName(String name);
	
	public String searchShowsJsonResultByName(String name);
	
	public List<Show> searchShowsByName(String name);
	
	public List<Show> getPaginationList(int pnum);
	
	public String getPaginationListJsonResult(int pnum);
	
	public String getCastListJsonResult(int sid);
	
	public List<Cast> getCastList(int sid);
	
	public String getCrewsListJsonResult(int sid);
	
	public List<Crew> getCrewsList(int sid);
}