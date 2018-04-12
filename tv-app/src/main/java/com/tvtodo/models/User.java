package com.tvtodo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="t_user")
public class User {
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private Date lastLogoutDate = new Date();
	private List<SubscribedShow> subscribedShows;
	
	@Column(name="username",unique=true)
	@NotNull(message="username is required")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	public Date getLastLogoutDate() {
		return lastLogoutDate;
	}
	public void setLastLogoutDate(Date lastLogoutDate) {
		this.lastLogoutDate = lastLogoutDate;
	}
	
	@OneToMany(mappedBy="user",targetEntity=SubscribedShow.class, cascade=CascadeType.ALL)
	public List<SubscribedShow> getSubscribedShows() {
		return subscribedShows;
	}
	
	public void setSubscribedShows(List<SubscribedShow> subscribedShow) {
		this.subscribedShows = subscribedShow;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", lastLogoutDate=" + lastLogoutDate + ", subscribedShows="
				+ subscribedShows + "]";
	}
}
