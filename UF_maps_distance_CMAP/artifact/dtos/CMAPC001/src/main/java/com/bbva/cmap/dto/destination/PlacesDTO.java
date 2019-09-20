/**
 * 
 */
package com.bbva.cmap.dto.destination;

import com.bbva.apx.dto.AbstractDTO;

/**
 * @author DiegoJavier
 *
 */
public class PlacesDTO extends AbstractDTO {

	private static final long serialVersionUID = 8469529794134187919L;	
	private String origins;
	private String destinations;
		
	/**
	 * 
	 */
	public PlacesDTO() {
		super();
	}

	/**
	 * @return the origins
	 */
	public String getOrigins() {
		return origins;
	}
	
	/**
	 * @param origins the origins to set
	 */
	public void setOrigins(String origins) {
		this.origins = origins;
	}
	
	/**
	 * @return the destinations
	 */
	public String getDestinations() {
		return destinations;
	}
	
	/**
	 * @param destinations the destinations to set
	 */
	public void setDestinations(String destinations) {
		this.destinations = destinations;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PlacesDTO [origins=");
		builder.append(origins);
		builder.append(", destinations=");
		builder.append(destinations);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destinations == null) ? 0 : destinations.hashCode());
		result = prime * result + ((origins == null) ? 0 : origins.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlacesDTO other = (PlacesDTO) obj;
		if (destinations == null) {
			if (other.destinations != null)
				return false;
		} else if (!destinations.equals(other.destinations))
			return false;
		if (origins == null) {
			if (other.origins != null)
				return false;
		} else if (!origins.equals(other.origins))
			return false;
		return true;
	}

}
