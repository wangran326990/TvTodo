package com.tvtodo.models;

import java.util.Date;

public class Season {
	private int id;
	private String url;
	private int number;
	private String name;
	private int episodeOrder;
	private Date premiereDate;
	private Date endDate;
	private Network network;
	private WebChannel webChannel;
	private Image image;
	private String summary;
	
	
	@Override
	public String toString() {
		return "Season [id=" + id + ", url=" + url + ", number=" + number + ", name=" + name + ", episodeOrder="
				+ episodeOrder + ", premiereDate=" + premiereDate + ", endDate=" + endDate + ", network=" + network
				+ ", webChannel=" + webChannel + ", image=" + image + ", summary=" + summary + "]";
	}
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEpisodeOrder() {
		return episodeOrder;
	}
	public void setEpisodeOrder(int episodeOrder) {
		this.episodeOrder = episodeOrder;
	}
	public Date getPremiereDate() {
		return premiereDate;
	}
	public void setPremiereDate(Date premiereDate) {
		this.premiereDate = premiereDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Network getNetwork() {
		return network;
	}
	public void setNetwork(Network network) {
		this.network = network;
	}
	public WebChannel getWebChannel() {
		return webChannel;
	}
	public void setWebChannel(WebChannel webChannel) {
		this.webChannel = webChannel;
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
}