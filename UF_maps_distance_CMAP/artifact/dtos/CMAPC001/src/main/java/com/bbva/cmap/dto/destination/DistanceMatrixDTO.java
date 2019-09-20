/**
 * 
 */
package com.bbva.cmap.dto.destination;

import java.util.List;

import com.bbva.apx.dto.AbstractDTO;

/**
 * @author DiegoJavier
 *
 */
public class DistanceMatrixDTO extends AbstractDTO {

	private static final long serialVersionUID = 1204577392284527903L;	
	private List<String> destination_addresses;
	private List<String> origin_addresses;
	private List<RowsDTO> rows;
		
	/**
	 * 
	 */
	public DistanceMatrixDTO() {
		super();
	}

	/**
	 * @return the destination_addresses
	 */
	public List<String> getDestination_addresses() {
		return destination_addresses;
	}
	
	/**
	 * @param destination_addresses the destination_addresses to set
	 */
	public void setDestination_addresses(List<String> destination_addresses) {
		this.destination_addresses = destination_addresses;
	}
	
	/**
	 * @return the origin_addresses
	 */
	public List<String> getOrigin_addresses() {
		return origin_addresses;
	}
	
	/**
	 * @param origin_addresses the origin_addresses to set
	 */
	public void setOrigin_addresses(List<String> origin_addresses) {
		this.origin_addresses = origin_addresses;
	}
	
	/**
	 * @return the rows
	 */
	public List<RowsDTO> getRows() {
		return rows;
	}
	
	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<RowsDTO> rows) {
		this.rows = rows;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DistanceMatrixDTO [destination_addresses=");
		builder.append(destination_addresses);
		builder.append(", origin_addresses=");
		builder.append(origin_addresses);
		builder.append(", rows=");
		builder.append(rows);
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
		result = prime * result + ((destination_addresses == null) ? 0 : destination_addresses.hashCode());
		result = prime * result + ((origin_addresses == null) ? 0 : origin_addresses.hashCode());
		result = prime * result + ((rows == null) ? 0 : rows.hashCode());
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
		DistanceMatrixDTO other = (DistanceMatrixDTO) obj;
		if (destination_addresses == null) {
			if (other.destination_addresses != null)
				return false;
		} else if (!destination_addresses.equals(other.destination_addresses))
			return false;
		if (origin_addresses == null) {
			if (other.origin_addresses != null)
				return false;
		} else if (!origin_addresses.equals(other.origin_addresses))
			return false;
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else if (!rows.equals(other.rows))
			return false;
		return true;
	}
	
}
