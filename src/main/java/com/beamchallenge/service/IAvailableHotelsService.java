package com.beamchallenge.service;

import java.util.List;

import com.beamchallenge.exceptions.BusinessException;
import com.beamchallenge.exceptions.CommunationFailedException;
import com.beamchallenge.rest.model.AvailableHotelRequest;
import com.beamchallenge.rest.model.AvailableHotelsResponse;

public interface IAvailableHotelsService {

	public List<AvailableHotelsResponse> getAvailableHotels(AvailableHotelRequest request) throws CommunationFailedException, BusinessException ;
}
