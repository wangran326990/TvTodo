package com.tvtodo.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_subscribed_show")
public class SubscribedShow {




	private int id;

	private int showId;
	private Date lastUpdateDate;
	private String showName;
	private String showImageLink;
	private String countryCode;
	private User user;
	
	public SubscribedShow() {
		// TODO Auto-generated constructor stub
	}
	
	public SubscribedShow(Show show){
		this.showId = show.getId();
		this.lastUpdateDate= new Date();
		this.showName = show.getName();
		this.showImageLink = show.getImage().getOriginal();
		this.countryCode = show.getCountry().getCode();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShowId() {
		return showId;
	}
	public void setShowId(int showId) {
		this.showId = showId;
	}
	@Temporal(TemporalType.DATE)
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getShowName() {
		return showName;
	}
	public void setShowName(String showName) {
		this.showName = showName;
	}
	public String getShowImageLink() {
		return showImageLink;
	}
	public void setShowImageLink(String showImageLink) {
		this.showImageLink = showImageLink;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	@ManyToOne
	@JoinColumn(name="fk_user_id", nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "SubscribedShow [id=" + id + ", showId=" + showId + ", showName=" + showName + ", countryCode="
				+ countryCode + ", ]";
	}
	
	public SubscribedShow(int id, int showId, Date lastUpdateDate, String showName, String showImageLink,
			String countryCode) {
		super();
		this.id = id;
		this.showId = showId;
		this.lastUpdateDate = lastUpdateDate;
		this.showName = showName;
		this.showImageLink = showImageLink;
		this.countryCode = countryCode;
	}
	
}
