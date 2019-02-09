package com.beamchallenge.rest.model;

public class BestHotelResponse {
	
	private String hotel;
	private int hotelRate;
	private String roomAmenities;
	private String hotelFare;
	
	public String getRoomAmenities() {
		return roomAmenities;
	}
	public void setRoomAmenities(String roomAmenities) {
		this.roomAmenities = roomAmenities;
	}
	public String getHotelFare() {
		return hotelFare;
	}
	public void setHotelFare(String hotelFare) {
		this.hotelFare = hotelFare;
	}
	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public int getHotelRate() {
		return hotelRate;
	}
	public void setHotelRate(int hotelRate) {
		this.hotelRate = hotelRate;
	}
	
}
