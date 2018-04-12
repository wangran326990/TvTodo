package com.tvtodo.models;

import java.util.Date;
import java.util.List;

public class Schedule {
	private String time;
//	private String[] days;
	private String[] days;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String[] getDays() {
		return days;
	}
	public void setDays(String[] days) {
		this.days = days;
	}
	
//	public List<String> getDays() {
//		return days;
//	}
//	public void setDays(List<String> days) {
//		this.days = days;
//	}
	

}
