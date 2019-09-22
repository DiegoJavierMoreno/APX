package com.bbva.cmap.lib.r002.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.elara.utility.api.connector.APIConnector;
import com.bbva.elara.utility.api.connector.APIConnectorBuilder;

import com.bbva.cmap.lib.r002.CMAPR002;

public abstract class CMAPR002Abstract extends AbstractLibrary implements CMAPR002 {

	private static final Logger LOGGER = LoggerFactory.getLogger(CMAPR002.class);
	
	protected ApplicationConfigurationService applicationConfigurationService;
	
	protected APIConnector externalApiConnector;

		
	protected APIConnectorBuilder apiConnectorBuilder;	
	
	/**
	 * @param applicationConfigurationService the applicationConfigurationService to set
	 */
	public void setApplicationConfigurationService(
			ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}
	
	
	/**
	 * @param externalApiConnector the externalApiConnector to set
	 */
	public void setExternalApiConnector(APIConnector externalApiConnector) {
		this.externalApiConnector = externalApiConnector;
	}
	
	/**
	 * @param apiConnectorBuilder the apiConnectorBuilder to set
	 */
	public void setApiConnectorBuilder(APIConnectorBuilder apiConnectorBuilder) {
		this.apiConnectorBuilder = apiConnectorBuilder;
	}
			
}
