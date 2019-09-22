package com.bbva.cmap;

import com.bbva.cmap.dto.destination.OutDTO;
import com.bbva.cmap.dto.destination.PlacesDTO;

import com.bbva.elara.transaction.AbstractTransaction;

public abstract class AbstractCMAPT00101COTransaction extends AbstractTransaction {

	public AbstractCMAPT00101COTransaction(){
	}
	
	

	/**
	 * Return value for input parameter places
	 */
	protected PlacesDTO getPlaces(){
		return (PlacesDTO)getParameter("places");
	}
	
	
	

	/**
	 * Set value for output parameter trip
	 */
	protected void setTrip(final OutDTO field){
		this.addParameter("trip", field);
	}			
	
}
