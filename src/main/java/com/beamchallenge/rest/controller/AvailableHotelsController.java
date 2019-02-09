package com.beamchallenge.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;

import com.beamchallenge.exceptions.BusinessException;
import com.beamchallenge.exceptions.CommunationFailedException;
import com.beamchallenge.rest.model.AvailableHotelRequest;
import com.beamchallenge.rest.model.AvailableHotelsResponse;
import com.beamchallenge.service.IAvailableHotelsService;

/***
 * A class to call an APIs to get the available hotels 
 *
 */
@Controller
@RequestMapping("/availablehotels")
public class AvailableHotelsController {

	final static Logger logger = Logger.getLogger(AvailableHotelsController.class);
	
	@Autowired
	IAvailableHotelsService availableHotelsService;

	
	@PostMapping("/getavailable")	
	public @ResponseBody List<AvailableHotelsResponse> getAvailableHotels(@RequestBody AvailableHotelRequest request) {
		
		List<AvailableHotelsResponse> availableHotelsResponses = null;
		try {
			logger.info("AvailableHotelRequest  " + request.toString());			
			availableHotelsResponses = availableHotelsService.getAvailableHotels(request);			
			logger.info("AvailableHotelsResponses  " + availableHotelsResponses.toString());
		} catch (CommunationFailedException e) {
			logger.error("getAvailableHotels   CommunationFailedException" + Arrays.toString(e.getStackTrace()));
			throw new MultipartException(e.getErrorObj().getErrorMessage());
		}catch(BusinessException e){
			logger.error("getAvailableHotels   BusinessException" + Arrays.toString(e.getStackTrace()));
			throw new MultipartException(e.getErrorObj().getErrorMessage());			
		}
		return availableHotelsResponses;
	}
}
