package com.beamchallenge.rest.model;

import java.io.Serializable;
import java.util.Arrays;

public class CrazyHotelResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String hotelName;
	private String rate;
	private String price;
	private String discount;
	private String [] amenities;
	
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String[] getAmenities() {
		return amenities;
	}
	public void setAmenities(String[] amenities) {
		this.amenities = amenities;
	}
	@Override
	public String toString() {
		return "CrazyHotelResponse [hotelName=" + hotelName + ", rate=" + rate + ", price=" + price + ", discount="
				+ discount + ", amenities=" + Arrays.toString(amenities) + "]";
	}
	

}
