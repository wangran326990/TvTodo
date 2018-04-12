package com.tvtodo.models;

import java.util.Date;
import java.util.List;



public class Show {
	private int id;
	private String url;
	private String name;
	private String type;
	private String language;
	//private List<String> genres;
	private String[] genres;
	private String status;
	private double runtime;
	private Date premiered;
	private String officialSite;
	private Schedule schedule;
	private Rating rating;
	private int weight;
	private Network network;
	private WebChannel webChannel;
	private Externals externals;
	private Image image;
	private String summary;
	private long updated;
	private Country country; 
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getRuntime() {
		return runtime;
	}
	public void setRuntime(double runtime) {
		this.runtime = runtime;
	}
	public Date getPremiered() {
		return premiered;
	}
	public void setPremiered(Date premiered) {
		this.premiered = premiered;
	}
	public String getOfficialSite() {
		return officialSite;
	}
	public void setOfficialSite(String officialSite) {
		this.officialSite = officialSite;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public WebChannel getWebChannel() {
		return webChannel;
	}
	public void setWebChannel(WebChannel webChannel) {
		this.webChannel = webChannel;
	}
	public Externals getExternals() {
		return externals;
	}
	public void setExternals(Externals externals) {
		this.externals = externals;
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
	public long getUpdated() {
		return updated;
	}
	public void setUpdated(long updated) {
		this.updated = updated;
	}
//	public List<String> getGenres() {
//		return genres;
//	}
//	public void setGenres(List<String> genres) {
//		this.genres = genres;
//	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public Network getNetwork() {
		return network;
	}
	public void setNetwork(Network network) {
		this.network = network;
	}
	public String[] getGenres() {
		return genres;
	}
	public void setGenres(String[] genres) {
		this.genres = genres;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
}
