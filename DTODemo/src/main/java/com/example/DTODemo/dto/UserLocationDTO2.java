package com.example.DTODemo.dto;

public class UserLocationDTO2 {
	
	private Long userId;
	
	private NameDTO name;
	
	private PlaceDTO placeDetails;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public NameDTO getName() {
		return name;
	}

	public void setName(NameDTO name) {
		this.name = name;
	}

	public PlaceDTO getPlaceDetails() {
		return placeDetails;
	}

	public void setPlaceDetails(PlaceDTO placeDetails) {
		this.placeDetails = placeDetails;
	}
	
	
	
	

}
