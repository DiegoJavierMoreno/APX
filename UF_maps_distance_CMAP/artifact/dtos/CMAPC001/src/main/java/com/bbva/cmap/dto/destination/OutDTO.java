/**
 * 
 */
package com.bbva.cmap.dto.destination;

import com.bbva.apx.dto.AbstractDTO;

/**
 * @author DiegoJavier
 *
 */
public class OutDTO extends AbstractDTO {

	private static final long serialVersionUID = 5560547395821666057L;
	private DescriptorDTO distance;
	private DescriptorDTO duration;
	private DescriptorDTO fare;
	
	/**
	 * 
	 */
	public OutDTO() {
		super();
	}
	
	/**
	 * @return the distance
	 */
	public DescriptorDTO getDistance() {
		return distance;
	}
	
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(DescriptorDTO distance) {
		this.distance = distance;
	}
	
	/**
	 * @return the duration
	 */
	public DescriptorDTO getDuration() {
		return duration;
	}
	
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(DescriptorDTO duration) {
		this.duration = duration;
	}
	
	/**
	 * @return the fare
	 */
	public DescriptorDTO getFare() {
		return fare;
	}
	
	/**
	 * @param fare the fare to set
	 */
	public void setFare(DescriptorDTO fare) {
		this.fare = fare;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OutDTO [distance=");
		builder.append(distance);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", fare=");
		builder.append(fare);
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
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((fare == null) ? 0 : fare.hashCode());
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
		OutDTO other = (OutDTO) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (fare == null) {
			if (other.fare != null)
				return false;
		} else if (!fare.equals(other.fare))
			return false;
		return true;
	}
	
}
