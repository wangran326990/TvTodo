package com.tvtodo.api;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tvtodo.jsonserializer.JsonSerializerHelper;
import com.tvtodo.models.Externals;
import com.tvtodo.models.Schedule;
import com.tvtodo.models.Show;

public class JsonSerializerHelperTest {

	@Test
	public void testSerializer() throws Exception {
		Map<String, String> mapShow = new HashMap<>();
		mapShow.put("status", "testStatus");
		mapShow.put("id", "testId");
		mapShow.put("externals", "externals-int");
		mapShow.put("schedule", "schedule-int");
		Map<String, String> mapExternals = new HashMap<>();
		mapExternals.put("imdb", "Imdb");
		mapExternals.put("id", "testId");
		
		JsonSerializerHelper<Externals> helperExternals = new JsonSerializerHelper<>(mapExternals);
		JsonSerializerHelper<Show> helperShow = new JsonSerializerHelper<>(mapShow);

		Show show = new Show();
		Externals external = new Externals();
		Schedule schedule = new Schedule();
		//schedule.setTime(new Date());
		ArrayList<String> list = new ArrayList<>();
		list.add("Test 1");
		list.add("Test 2");
		list.add("Test 3");
		list.add("Test 4");
		//schedule.setDays(list);
		external.setId(1);
		external.setImdb("string test");
		show.setId(1);
		//show.setStatus("Ended");
		show.setExternals(external);
		show.setSchedule(schedule);
		 final GsonBuilder gsonBuilder = new GsonBuilder();
		    gsonBuilder.registerTypeAdapter(Show.class, helperShow);
		    gsonBuilder.registerTypeAdapter(Externals.class, helperExternals);
		    gsonBuilder.serializeNulls();
		    gsonBuilder.setPrettyPrinting();
		    Gson gson = gsonBuilder.create();
		  System.out.println(gson.toJson(show));
	}

}
