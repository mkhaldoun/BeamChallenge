package com.beamchallenge.configuration.holder;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.beamchallenge.application.enums.HotelProviders;

/***
 * 
 * Class holder to get the providers URLs from resource file
 *
 */
public class ApplicationUrlsHolder {
	
	private ResourceBundle applicationUrlsBundle;
	
	public ApplicationUrlsHolder() {
		applicationUrlsBundle = ResourceBundle.getBundle("application_urls");
	}
	
	public ApplicationUrlsHolder(String applicationUrlsFileName) {
		if (applicationUrlsFileName == null || applicationUrlsFileName.trim().isEmpty()) {
			throw new IllegalArgumentException("Please pass a valid file name, the passed file value is "+ applicationUrlsFileName);
		}
		applicationUrlsBundle = ResourceBundle.getBundle(applicationUrlsFileName);
	}
	
	/***
	 * This method get the providers links from source folder
	 * @return Map contains each provider and his service link
	 */
	public Map<HotelProviders, String> getHotelProvidersUrls() {
		String crazyHotelUrl = applicationUrlsBundle.getString("hotel.reservations.url.crazy.hotel");
		String bestHotelUrl = applicationUrlsBundle.getString("hotel.reservations.url.best.hotel");
		
		Map<HotelProviders, String> providerUrls = new HashMap<>();
		
		providerUrls.put(HotelProviders.CRAZY_HOTEL, crazyHotelUrl);
		providerUrls.put(HotelProviders.BEST_HOTEL, bestHotelUrl);
		return providerUrls;
	}

}