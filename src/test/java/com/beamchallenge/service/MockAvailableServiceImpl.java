package com.beamchallenge.service;

import java.util.ArrayList;
import java.util.List;

import com.beamchallenge.exceptions.BusinessException;
import com.beamchallenge.exceptions.CommunationFailedException;
import com.beamchallenge.rest.model.AvailableHotelRequest;
import com.beamchallenge.rest.model.AvailableHotelsResponse;

public class MockAvailableServiceImpl {

	public List<AvailableHotelsResponse> getAvailableHotels(AvailableHotelRequest request) throws CommunationFailedException, BusinessException {
		
		List<AvailableHotelsResponse> availableHotelsResponses = new ArrayList<>();
		String [] amenities = {"snacks","drinks"};	
		
		AvailableHotelsResponse availableHotelsResponse = new AvailableHotelsResponse();
		availableHotelsResponse.setRate(4);
		availableHotelsResponse.setAmenities(amenities);
		availableHotelsResponse.setFare("150");
		availableHotelsResponse.setHotelname("BlackNight");
		availableHotelsResponse.setProvider("BestHotel");
		
		AvailableHotelsResponse availableHotelsResponse2 = new AvailableHotelsResponse();
		availableHotelsResponse2.setRate(5);			
		availableHotelsResponse2.setAmenities(amenities);
		availableHotelsResponse2.setFare("190");
		availableHotelsResponse2.setHotelname("Starts");
		availableHotelsResponse2.setProvider("CrazyHotel");
		
		availableHotelsResponses.add(availableHotelsResponse);
		availableHotelsResponses.add(availableHotelsResponse2);
		
		return availableHotelsResponses;
	}
	
}
