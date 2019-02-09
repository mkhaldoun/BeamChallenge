package com.beamchallenge.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.beamchallenge.exceptions.BusinessException;
import com.beamchallenge.exceptions.CommunationFailedException;
import com.beamchallenge.http.callers.HttpCaller;
import com.beamchallenge.rest.model.AvailableHotelRequest;
import com.beamchallenge.rest.model.AvailableHotelsResponse;
import com.beamchallenge.service.impl.AvailableHotelsAggregatorService;
import com.google.gson.Gson;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class AvailableHotelsAggregatorServiceTest  extends TestCase{
	
	@Mock
	private HttpCaller httpCaller;
	
	@InjectMocks
	private AvailableHotelsAggregatorService aggregatorService;
	
	private List<AvailableHotelsResponse> expectedList = new ArrayList<AvailableHotelsResponse>();
	
	private AvailableHotelRequest dummyRequest = new AvailableHotelRequest();
	
	private String dummySuccessCrazyHotelsResponse = "";
	
	private String dummySuccessBestHotelsResponse = "";


	@Before
	public void Setup() {
		
		// [{"hotel":"BlackNight","hotelRate":5,"hotelFare":"180","roomAmenities":"Snacks,Drinks"},{"hotel":"Mars","hotelRate":5,"hotelFare":"210","roomAmenities":"Snacks,Drinks,extra bed"}] 
		dummySuccessCrazyHotelsResponse = "[{\"hotelName\":\"CrazyHotel1\", \"rate\":\"****\", \"price\":\"50\", \"discount\":\"5\", \"amenities\":[ \"Dryer\", \"Towels\"]}]";
		
		// { "hotel":"BestHotel1", "hotelRate":"4", "hotelFare":"22", "roomAmenities":"Dryer,Towels" }
		dummySuccessBestHotelsResponse = "[{\"hotel\":\"BlackNight\",\"hotelRate\":5,\"hotelFare\":\"180\",\"roomAmenities\":\"Snacks,Drinks\"},{\"hotel\":\"Mars\",\"hotelRate\":5,\"hotelFare\":\"210\",\"roomAmenities\":\"Snacks,Drinks,extra bed\"}]"; 

		
		AvailableHotelsResponse bestHotelExpectedResponse1 = new AvailableHotelsResponse();
		bestHotelExpectedResponse1.setProvider("BestHotel");
		bestHotelExpectedResponse1.setHotelname("BlackNight");
		bestHotelExpectedResponse1.setFare("180");
		bestHotelExpectedResponse1.setAmenities(new String[] {"Snacks", "Drinks"});
		bestHotelExpectedResponse1.setRate(5);
		
 		AvailableHotelsResponse bestHotelExpectedResponse2 = new AvailableHotelsResponse();
 		bestHotelExpectedResponse2.setProvider("BestHotel");
 		bestHotelExpectedResponse2.setHotelname("Mars");
 		bestHotelExpectedResponse2.setFare("210");
 		bestHotelExpectedResponse2.setAmenities(new String[] {"Snacks", "Drinks", "extra bed"});
 		bestHotelExpectedResponse2.setRate(5);

 		AvailableHotelsResponse crazyHotelExpectedResponse = new AvailableHotelsResponse();
		crazyHotelExpectedResponse.setProvider("CrazyHotel");
		crazyHotelExpectedResponse.setHotelname("CrazyHotel1");
		crazyHotelExpectedResponse.setFare("50");
		crazyHotelExpectedResponse.setAmenities(new String[] {"Dryer", "Towels"});
		crazyHotelExpectedResponse.setRate(4);
		
		expectedList.add(bestHotelExpectedResponse1);
		expectedList.add(bestHotelExpectedResponse2);
		expectedList.add(crazyHotelExpectedResponse);
		
		dummyRequest.setCity("AAA");
		dummyRequest.setFromDate("11-10-2018");
		dummyRequest.setToDate("11-10-2018");
		dummyRequest.setNumberOfAdults(5);
	}
	
	@Test
	public void TestGetAvailableHotels() throws BusinessException, CommunationFailedException {
		
		try {
			String crazyHotelProviderUrl = "http://localhost:8080/simgateway/rest/test/crazyhotel";
			String bestHotelProviderUrl = "http://localhost:8080/simgateway/rest/test/besthotel";
			
			Gson gson = new Gson();
			String jsonRequestString = gson.toJson(dummyRequest);
			
			Mockito.when(httpCaller.performHttpRequest(jsonRequestString, crazyHotelProviderUrl)).thenReturn(dummySuccessCrazyHotelsResponse);
			Mockito.when(httpCaller.performHttpRequest(jsonRequestString, bestHotelProviderUrl)).thenReturn(dummySuccessBestHotelsResponse);
			
			List<AvailableHotelsResponse> testResultList = aggregatorService.getAvailableHotels(dummyRequest);			
			assertEquals(expectedList, testResultList);
			
		} catch (Exception e) {
			Assert.fail("Exception " + e);
		}
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenAvailableHotelsResponseIsNull_thenIllegalArgumentExceptionThrown() {
		
		try {
			Mockito.when(aggregatorService.getAvailableHotels(null)).thenThrow(IllegalArgumentException.class);
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (CommunationFailedException e) {
			e.printStackTrace();
		}
	       
	}

}
