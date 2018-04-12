package com.tvtodo.models;

import java.util.Date;

public class Episode {
	private int id;
	private String url;
	private String name;
	private int season;
	private int number;
	private Date airdate;
	private String airtime;
	private Date airstamp;
	private double runtime;
	private Image image;
	private String summary;
	private Show show;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSeason() {
		return season;
	}
	public void setSeason(int season) {
		this.season = season;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getAirdate() {
		return airdate;
	}
	public void setAirdate(Date airdate) {
		this.airdate = airdate;
	}
	public String getAirtime() {
		return airtime;
	}
	public void setAirtime(String airtime) {
		this.airtime = airtime;
	}
	public Date getAirstamp() {
		return airstamp;
	}
	public void setAirstamp(Date airstamp) {
		this.airstamp = airstamp;
	}
	public double getRuntime() {
		return runtime;
	}
	public void setRuntime(double runtime) {
		this.runtime = runtime;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	
}
