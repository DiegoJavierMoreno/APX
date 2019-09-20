/**
 * 
 */
package com.bbva.cmap.dto.destination;

import com.bbva.apx.dto.AbstractDTO;

/**
 * @author DiegoJavier
 *
 */
public class ElementsDTO extends AbstractDTO {

	private static final long serialVersionUID = 1323946993672290392L;
	private DescriptorDTO distance;
	private DescriptorDTO duration;
	private String status;
	
	/**
	 * 
	 */
	public ElementsDTO() {
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ElementsDTO [distance=");
		builder.append(distance);
		builder.append(", duration=");
		builder.append(duration);
		builder.append(", status=");
		builder.append(status);
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
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		ElementsDTO other = (ElementsDTO) obj;
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
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
