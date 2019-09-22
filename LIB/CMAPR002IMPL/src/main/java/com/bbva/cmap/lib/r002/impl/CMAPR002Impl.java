package com.bbva.cmap.lib.r002.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.bbva.cmap.lib.r002.CMAPR002;

public class CMAPR002Impl extends CMAPR002Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CMAPR002.class);
	private static final String API_KEY = "AIzaSyCfXjz0QMVfZW4KEFmJijdfJEuGEO-afMM";
	private static final String LOGICAL_RESOURCE_API_MAPS = "https://maps.googleapis.com/maps/api/distancematrix/json";
		
	/**
	 * Execute invoke API Direction Matrix Google
	 * @param origin = Departure place
	 * @param destination = Arrival place
	 */
	@Override
	public String executeMatrixMapAPI(String origin, String destination) {
		
		LOGGER.info(">>> Execute api connector external Distance Matrix API <<<");
		LOGGER.info("Outside origin {}", origin);
		LOGGER.info("Outside destination {}", destination);
		String responseExcute = null;
		if (origin != null && !origin.isEmpty() && destination != null && !destination.isEmpty()) {
			
			LOGGER.info("Inside origin {} destination {}", origin, destination);
			LOGGER.info("Inside API_KEY " + API_KEY);
			
			// RestTemplate
			RestTemplate restTemplate = new RestTemplate();
			
			// Request Header
			HttpHeaders httpHeader = new HttpHeaders();
			httpHeader.setContentType(MediaType.APPLICATION_JSON);
			// Request Object
			// Query parameters
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(LOGICAL_RESOURCE_API_MAPS)
			        // Add query parameter
			        .queryParam("units", "metric")
			        .queryParam("origins", origin)
        			.queryParam("destinations", destination)
			        .queryParam("key", API_KEY);        			
			
			LOGGER.info("URL full => {}", builder.build().toUri());
			
			try {
				// EXTERNAL API CONNECTOR
				// ResponseEntity<String> res = this.externalApiConnector.getForEntity(LOGICAL_RESOURCE_API_MAPS, String.class, queryParams);
				ResponseEntity<String> res = restTemplate.getForEntity(builder.build().toUri(), String.class);
				LOGGER.info("Status Code: {}", res.getStatusCode());
				responseExcute = res.getBody();
				LOGGER.info("Body: {}", responseExcute);
			}catch(Exception ex) {
				LOGGER.error(ex.getMessage());
			}
		}
		
		return responseExcute;
		
	}
}
