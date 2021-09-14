package com.example.DTODemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name= "latitude")
	private double latitude;
	
	@Column(name = "longitude")
	private double longitude;
	
	@Column(name = "place")
	private String place;
	
	@Column(name = "description")
	private String description;
	
	
//	@OneToMany(mappedBy = "location" , cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
//			CascadeType.DETACH, CascadeType.REFRESH})
	
//	@OneToMany(mappedBy = "location" , cascade = CascadeType.ALL)
	
	@OneToMany(mappedBy = "location" , cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			CascadeType.DETACH, CascadeType.REFRESH})
	private List<User> users;


	public Location() {
		
	}


	


	public Location(double latitude, double longitude, String place, String description) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.place = place;
		this.description = description;
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}





	@Override
	public String toString() {
		return "Location [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", place=" + place
				+ ", description=" + description + "]";
	}


	
	
	
	
	
	
}
