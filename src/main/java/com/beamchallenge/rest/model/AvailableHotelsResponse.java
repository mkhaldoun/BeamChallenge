package com.beamchallenge.rest.model;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AvailableHotelsResponse implements Comparable<AvailableHotelsResponse>, Serializable {

	private static final long serialVersionUID = 1L;
	private String provider;
	private String hotelname;
	private String fare;
	private String[] amenities;
	
	@JsonIgnore
	private Integer rate;
	
	public AvailableHotelsResponse() {
		super();
	}
	
	public AvailableHotelsResponse(String provider, String hotelname, String fare, String[] amenities, Integer rate) {
		super();
		this.provider = provider;
		this.hotelname = hotelname;
		this.fare = fare;
		this.amenities = amenities;
		this.rate = rate;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
	}
	public String[] getAmenities() {
		return amenities;
	}
	public void setAmenities(String[] amenities) {
		this.amenities = amenities;
	}
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "AvailableHotelsResponse [provider=" + provider + ", hotelname=" + hotelname + ", fare=" + fare
				+ ", amenities=" + Arrays.toString(amenities) + ", rate=" + rate + "]";
	}

	@Override
	public int compareTo(AvailableHotelsResponse o) {
		return Integer.compare(o.rate,this.rate);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(amenities);
		result = prime * result + ((fare == null) ? 0 : fare.hashCode());
		result = prime * result + ((hotelname == null) ? 0 : hotelname.hashCode());
		result = prime * result + ((provider == null) ? 0 : provider.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvailableHotelsResponse other = (AvailableHotelsResponse) obj;
		if (!Arrays.equals(amenities, other.amenities))
			return false;
		if (fare == null) {
			if (other.fare != null)
				return false;
		} else if (!fare.equals(other.fare))
			return false;
		if (hotelname == null) {
			if (other.hotelname != null)
				return false;
		} else if (!hotelname.equals(other.hotelname))
			return false;
		if (provider == null) {
			if (other.provider != null)
				return false;
		} else if (!provider.equals(other.provider))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		return true;
	}
	
	
	
}
