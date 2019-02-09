package com.beamchallenge.rest.model;

import java.io.Serializable;

public class AvailableHotelRequest implements Serializable{

	private static final long serialVersionUID = -6579459390287074336L;
	
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mmm-yyyy")
	private String fromDate;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mmm-yyyy")
	private String toDate;
	private String city;
	private int numberOfAdults;
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getNumberOfAdults() {
		return numberOfAdults;
	}
	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}
	@Override
	public String toString() {
		return "AvailableHotelRequest [fromDate=" + fromDate + ", toDate=" + toDate + ", city=" + city
				+ ", numberOfAdults=" + numberOfAdults + "]";
	}
	
}
