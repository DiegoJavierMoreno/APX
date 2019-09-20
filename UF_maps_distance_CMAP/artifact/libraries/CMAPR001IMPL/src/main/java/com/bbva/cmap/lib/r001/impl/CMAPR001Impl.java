package com.bbva.cmap.lib.r001.impl;

import java.io.StringReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.cmap.dto.destination.DescriptorDTO;
import com.bbva.cmap.dto.destination.DistanceMatrixDTO;
import com.bbva.cmap.dto.destination.OutDTO;
import com.bbva.cmap.dto.destination.PlacesDTO;
import com.bbva.cmap.lib.r001.CMAPR001;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.bbva.cmap.lib.r002.CMAPR002;

public class CMAPR001Impl extends CMAPR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(CMAPR001.class);
	
	private CMAPR002 CMAPR002;
	
	/**
	 * 
	 * @param CMAPR002
	 */
    public void setCMAPR002(CMAPR002 CMAPR002){
        this.CMAPR002 = CMAPR002;
    }	
	
	/**
	 * Method main for interact with LI
	 */
	@Override
	public OutDTO executeAPIMaps(PlacesDTO places) {
		
		LOGGER.info("Start executeAPIMaps");
		LOGGER.info("DTO input Format 1 => " + places.toString());
		OutDTO dataOut = new OutDTO();
		DistanceMatrixDTO data = null;
		LOGGER.info("Dont forget delete => " + places);
		String response = CMAPR002.executeMatrixMapAPI(places.getOrigins(), places.getDestinations());
				
		if (response == null) {
			LOGGER.info("FAILED");
		}else{
			LOGGER.info("Response LInfra: {} ", response);
			
			Gson gson = new Gson();
			JsonReader reader = new JsonReader(new StringReader(response.toString()));
			reader.setLenient(true);
			data = gson.fromJson(reader, DistanceMatrixDTO.class);
			LOGGER.info("data Json {}", data);
			if (data != null) {
				LOGGER.info("DistanceMatrixDTO: OUT {} ", data.toString());
				dataOut.setDistance(data.getRows().get(0).getElements().get(0).getDistance());
				dataOut.setDuration(data.getRows().get(0).getElements().get(0).getDuration());
				dataOut.setFare(getFare(data));
			}
		}

		return dataOut;
	}
	
	/**
	 * Calculate logic for total fare on this route.
	 * @param dataJob
	 * @return
	 */
	private DescriptorDTO getFare(DistanceMatrixDTO dataJob) {
		DescriptorDTO descriptorDTO = new DescriptorDTO();
		double cost;
		
		// 9.500 oil each 25km (40 L)
		cost = (double)(dataJob.getRows().get(0).getElements().get(0).getDistance().getValue() * 9500) / 25000;
		descriptorDTO.setValue((long)cost);
		descriptorDTO.setText("COP");
		
		return descriptorDTO;
	}
	
}
