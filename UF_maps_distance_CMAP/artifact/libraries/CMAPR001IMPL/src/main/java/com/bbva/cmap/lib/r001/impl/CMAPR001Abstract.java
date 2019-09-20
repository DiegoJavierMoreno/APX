package com.bbva.cmap.lib.r001.impl;

import com.bbva.cmap.lib.r002.CMAPR002;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.library.AbstractLibrary;
import com.bbva.cmap.lib.r001.CMAPR001;

public abstract class CMAPR001Abstract extends AbstractLibrary implements CMAPR001 {
	protected CMAPR002 cmapR002;

	private static final Logger LOGGER = LoggerFactory.getLogger(CMAPR001.class);
	
	protected ApplicationConfigurationService applicationConfigurationService;
	
	/**
	 * @param applicationConfigurationService the applicationConfigurationService to set
	 */
	public void setApplicationConfigurationService(
			ApplicationConfigurationService applicationConfigurationService) {
		this.applicationConfigurationService = applicationConfigurationService;
	}
	
	public void setCmapR002(CMAPR002 cmapR002)
	{
		this.cmapR002 = cmapR002;
	}
}
