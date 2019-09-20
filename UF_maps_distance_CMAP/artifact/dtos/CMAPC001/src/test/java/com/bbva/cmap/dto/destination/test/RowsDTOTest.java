/**
 * 
 */
package com.bbva.cmap.dto.destination.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bbva.cmap.dto.destination.ElementsDTO;
import com.bbva.cmap.dto.destination.PlacesDTO;
import com.bbva.cmap.dto.destination.RowsDTO;

import junit.framework.Assert;

/**
 * @author DiegoJavier
 *
 */
public class RowsDTOTest {

	RowsDTO rowsDTO;
	List<ElementsDTO> elements;	
	
	@Before
	public void setUp() {
		rowsDTO = new RowsDTO();
		elements = new ArrayList<>();
		rowsDTO.setElements(elements);
	}
	
	@Test 
	public void testToString() {
		Assert.assertNotSame(rowsDTO.getElements().toString(), rowsDTO.toString()); 
	}
	
	@Test 
	public void testHashCode() {
		Assert.assertNotSame(new RowsDTO().hashCode(), rowsDTO.hashCode()); 
	}
	
	@Test 
	public void testEquals() {
		Assert.assertEquals(rowsDTO.equals(rowsDTO), true);
		Assert.assertEquals(rowsDTO.equals(null), false);
		Assert.assertEquals(rowsDTO.equals(123), false);
		RowsDTO objectOther = new RowsDTO();
		Assert.assertEquals(objectOther.equals(rowsDTO), false);
		Assert.assertEquals(rowsDTO.equals(objectOther), false);		
	}

}
