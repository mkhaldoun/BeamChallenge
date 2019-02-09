package com.beamchallenge.http.callers;

import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.beamchallenge.exceptions.CommunationFailedException;
import com.beamchallenge.exceptions.ErrorObj;
import com.beamchallenge.utils.ApplicationConstants;

/***
 * <p>
 * This Class make the HTTP Calles to an API
 *
 */
@Component
public class RestHttpCaller implements HttpCaller {


	/***
	 * This method used to perform the HTTP call, it receives and returns JSON
	 * as String value
	 * 
	 * 
	 * @param jsonString
	 * @return String
	 * @throws CommunationFailedException 
	 */
	public String performHttpRequest(String jsonString, String url) throws CommunationFailedException {
		
		if (url == null || url.trim().isEmpty()) {
			throw new IllegalArgumentException("The passed url are null or empty");
		}

		ResponseEntity<String> result = null;

		try {
			result = configureRestTemplate().exchange(url, HttpMethod.POST,
					new HttpEntity(jsonString, buildHeaderJson()), String.class);

			if (result == null || !result.getStatusCode().equals(HttpStatus.OK) || result.getBody() == null) {
				
				//TODO LOG
				ErrorObj errorObj = new ErrorObj();
				errorObj.setErrorCode(ApplicationConstants.COMMUNICATION_EXCEPTION);
				errorObj.setErrorMessage(ApplicationConstants.USER_GENERAL_EXCEPTION_MEG);
				
				throw new CommunationFailedException(errorObj);
			} 
		} catch (Exception e) {
			//TODO Log
			e.printStackTrace();
			ErrorObj errorObj = new ErrorObj();
			errorObj.setErrorCode(ApplicationConstants.COMMUNICATION_EXCEPTION);
			errorObj.setErrorMessage(ApplicationConstants.USER_GENERAL_EXCEPTION_MEG);
			
			throw new CommunationFailedException(errorObj);
		}
		return result.getBody();
	}

	private MultiValueMap<String, Object> buildHeaderJson() {
		
		MultiValueMap<String, Object> headers = new LinkedMultiValueMap<String, Object>();				
		headers.add("Content-Type", "application/json");
		headers.add("Accept", "application/json");
		return headers;
	}

	private RestTemplate configureRestTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		
		requestFactory.setConnectTimeout(50000);
		requestFactory.setReadTimeout(50000);
		restTemplate.setRequestFactory(requestFactory);

		restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
		restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());


		return restTemplate;
	}
}
