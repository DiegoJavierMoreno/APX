package com.bbva.cmap.lib.r001;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbva.cmap.dto.destination.OutDTO;
import com.bbva.cmap.dto.destination.PlacesDTO;
import com.bbva.cmap.lib.r001.impl.CMAPR001Impl;
import com.bbva.cmap.lib.r002.CMAPR002;

public class CMAPR001Test {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CMAPR001.class);
	
	@InjectMocks
	private CMAPR001Impl cmapR001;
	
	@Mock
	private CMAPR002 cmapR002;	
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);		
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.cmapR001;
		if(this.cmapR001 instanceof Advised){
			Advised advised = (Advised) this.cmapR001;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	/**
	 * Test main method for interact with LI
	 */
	@Test
	public void executeTest(){
		LOGGER.info("Executing the test...");
		PlacesDTO places = new PlacesDTO();
		places.setOrigins("New York City,N");
		places.setDestinations("Washington,DC");
		cmapR001.executeAPIMaps(places);
		Mockito.when(cmapR002.executeMatrixMapAPI("New York City,N", "Washington,DC")).thenReturn("{\"destination_addresses\":[\"Bogota, Colombia\"],\"origin_addresses\":[\"Mosquera, Cundinamarca, Colombia\"],\"rows\":[{\"elements\":[{\"distance\":{\"text\":\"16.3 mi\",\"value\":26182},\"duration\":{\"text\":\"52 mins\",\"value\":3091},\"status\":\"OK\"}]}],\"status\":\"OK\"}");
		cmapR001.executeAPIMaps(places);		
	}
	
}
