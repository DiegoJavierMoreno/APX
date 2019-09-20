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
public class RowsDTO extends AbstractDTO {

	private static final long serialVersionUID = 1578891487292170326L;
	private List<ElementsDTO> elements;
	
	/**
	 * 
	 */
	public RowsDTO() {
		super();
	}

	/**
	 * @return the elements
	 */
	public List<ElementsDTO> getElements() {
		return elements;
	}
	
	/**
	 * @param elements the elements to set
	 */
	public void setElements(List<ElementsDTO> elements) {
		this.elements = elements;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RowsDTO [elements=");
		builder.append(elements);
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
		result = prime * result + ((elements == null) ? 0 : elements.hashCode());
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
		RowsDTO other = (RowsDTO) obj;
		if (elements == null) {
			if (other.elements != null)
				return false;
		} else if (!elements.equals(other.elements))
			return false;
		return true;
	}

}
