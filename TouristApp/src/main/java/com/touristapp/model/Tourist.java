package com.touristapp.model;

public class Tourist {
	private String place;
	private Integer travelerId;
	private String category;
	private String state;
	private double cost;
	public Tourist() {
		super();
	}
	public Tourist(String place, String category, String state, double cost) {
		super();
		this.place = place;
		this.category = category;
		this.state = state;
		this.cost = cost;
	}
	
	
	public Tourist(String place, Integer travelerId, String category, String state, double cost) {
		super();
		this.place = place;
		this.travelerId = travelerId;
		this.category = category;
		this.state = state;
		this.cost = cost;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Integer getTravelerId() {
		return travelerId;
	}
	public void setTravelerId(Integer travelerId) {
		this.travelerId = travelerId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Place=" + place + ", Id=" + travelerId + ",Category=" + category + ", State=" + state
				+ ", Cost=" + cost  ;
	}
	
	

}
